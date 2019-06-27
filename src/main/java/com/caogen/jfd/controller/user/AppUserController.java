package com.caogen.jfd.controller.user;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUser.State;
import com.caogen.jfd.entity.user.AppUserInfo;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.service.user.AppUserInfoService;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserSmsService;
import com.caogen.jfd.service.user.AppUserThirdService;
import com.caogen.jfd.service.user.ConfigService;
import com.caogen.jfd.util.PasswordHelper;
import com.caogen.jfd.util.SmsUtils;
import com.google.gson.Gson;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("user")
public class AppUserController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserInfoService infoService;
	@Autowired
	private AppUserThirdService thirdService;
	@Autowired
	private AppUserSmsService smsService;
	@Autowired
	private ConfigService configService;

	/**
	 * 密码登录
	 * 
	 * @param user
	 * @return
	 */
	@ResponseBody
	@RequestMapping("login/password")
	public Message loginByPassword(AppUser user) {
		Message message = new Message();
		try {
			// 检查参数
			if (user.getPhone() == null || user.getPassword() == null) {
				throw new DefinedException(ErrorCode.PARAM_MISSING);
			}
			// 用户是否存在
			AppUser entity = userService.getByPhone(user.getPhone());
			if (entity == null || !entity.getState().equals(State.normal)) {
				throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
			}
			// 密码是否设置
			if (StringUtils.isEmpty(entity.getPassword())) {
				throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
			}
			// 密码是否正确
			String ciphertext = PasswordHelper.encryptPassword(user.getPassword(), entity.getSalt());
			if (!ciphertext.equals(entity.getPassword())) {
				throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
			}
			message.setData(generateToken(user.getPhone()));
		} catch (DefinedException e) {
			message.setErrorCode(e.getError());
			StaticLogger.error("user login error", e);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.LOGIN_ERROR);
			StaticLogger.error("user login error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("login/sms")
	public Message loginBySms(AppUser user, AppUserSms sms) {
		Message message = new Message();
		try {
			// 检查参数
			if (user.getPhone() == null || sms.getCode() == null) {
				throw new DefinedException(ErrorCode.PARAM_MISSING);
			}
			// 对比验证码
			contrastSms(user.getPhone(), sms.getCode());
			// 用户是否存在，不存在则创建用户
			AppUser entity = userService.getByPhone(user.getPhone());
			if (entity == null) {
				entity = new AppUser(user.getPhone());
				entity.setReferrer(user.getReferrer());
				userService.create(entity);
				infoService.create(new AppUserInfo(user.getPhone()));
			} else if (!entity.getState().equals(State.normal)) {
				throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
			}
			message.setData(generateToken(user.getPhone()));
		} catch (DefinedException e) {
			message.setErrorCode(e.getError());
			StaticLogger.error("user login error", e);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.LOGIN_ERROR);
			StaticLogger.error("user login error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("login/third")
	public Message loginByThird(AppUser user, AppUserSms sms, AppUserThird third) {
		Message message = new Message();
		try {
			// 检查参数
			if (third.getThirdparty() == null || third.getIdentifier() == null) {
				throw new DefinedException(ErrorCode.PARAM_MISSING);
			}
			AppUserThird entity = thirdService.getByProperty(third);
			if (entity == null) {
				// 检查参数
				if (user.getPhone() == null || sms.getCode() == null) {
					throw new DefinedException(ErrorCode.FIRST_LOGIN);
				}
				// 对比验证码
				contrastSms(user.getPhone(), sms.getCode());
				// 创建用户
				if (userService.getByPhone(user.getPhone()) == null) {
					userService.create(user);
					infoService.create(new AppUserInfo(user.getPhone()));
				}
				// 添加第三方应用记录
				third.setPhone(user.getPhone());
				thirdService.create(third);
			} else {
				user.setPhone(entity.getPhone());
			}
			message.setData(generateToken(user.getPhone()));
		} catch (DefinedException e) {
			message.setErrorCode(e.getError());
			StaticLogger.error("user login error", e);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.LOGIN_ERROR);
			StaticLogger.error("user login error", e);
		}
		return message;
	}

	/**
	 * 退出登录
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "logout", "api/logout" })
	public Message logout(String data) {
		Message message = new Message();
		try {
			AppUser user = Constants.gson.fromJson(data, AppUser.class);
			AppUser entity = userService.getByPhone(user.getPhone());
			entity.setToken(null);
			entity.setDes_key(null);
			entity.setDes_iv(null);
			userService.modify(entity);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.LOGOUT_ERROR);
			StaticLogger.error("user loginout error", e);
		}
		return message;
	}

	/**
	 * 密钥交换
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "signin", "api/signin" })
	public Message signin(String data) {
		Message message = new Message();
		try {
			Signin signin = new Gson().fromJson(data, Signin.class);
			String[] array = userService.exchangeKey(signin.getResult(), signin.getPhone());
			signin.setResult(array[0]);
			signin.setVerify(array[1]);
			message.setData(signin, Constants.DES_KEY, Constants.DES_IV);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SIGNIN_ERROR);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	/**
	 * 修改密码
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "cipher", "api/cipher" })
	public Message cipher(String data) {
		Message message = new Message();
		try {
			AppUser user = Constants.gson.fromJson(data, AppUser.class);
			userService.changePassword(user.getPhone(), user.getPassword());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.CIPHER_ERROR);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	/**
	 * 获取邀请人列表
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "referrer", "api/referrer" })
	public Message referrer(String data) {
		Message message = new Message();
		try {
			AppUser user = Constants.gson.fromJson(data, AppUser.class);
			AppUser entity = userService.getByPhone(user.getPhone());
			List<AppUser> list = userService.getLowerList(entity);
			message.setData(list, entity.getDes_key(), entity.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.FAIL);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	/**
	 * 获取短信验证码
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("sendSms")
	public Message sendSms(String phone) {
		Message message = new Message();
		try {
			// 发送验证码，成功则存储验证码
			String code = PasswordHelper.generateCode();
			boolean flag = SmsUtils.sendSms(phone, code);
			if (flag) {
				AppUserSms entity = new AppUserSms(phone);
				entity.setCode(code);
				smsService.create(entity);
			} else {
				throw new RuntimeException("验证码发送失败");
			}
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SMS_SEND_ERROR);
			StaticLogger.error("send sms error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("contrast")
	public Message contrast(String phone, String code) {
		Message message = new Message();
		try {
			contrastSms(phone, code);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SMS_MISMATCHING);
			StaticLogger.error("sms error", e);
		}
		return message;
	}

	/**
	 * 生成token
	 * 
	 * @param phone
	 * @return
	 */
	private String generateToken(String phone) {
		String token = PasswordHelper.generateNumber();
		AppUser entity = new AppUser(phone);
		entity.setToken(token);
		userService.modify(entity);
		return token;
	}

	/**
	 * 对比验证码
	 * 
	 * @param phone
	 * @param sms
	 * @throws Exception
	 */
	private void contrastSms(String phone, String sms) throws Exception {
		// 查询该条验证码记录
		AppUserSms entity = new AppUserSms();
		entity.setPhone(phone);
		AppUserSms userSms = smsService.getByPhone(phone);
		if (userSms == null) {
			throw new DefinedException(ErrorCode.SMS_INEXISTENCE);
		}
		// 验证码是否在有效期内
		Long indate = Long.parseLong(configService.getByItem("indate").getItem_value());
		Duration duration = Duration.between(userSms.getCreate_date(), LocalDateTime.now());
		if (duration.toMillis() > indate) {
			throw new DefinedException(ErrorCode.SMS_PAST);
		}
		if (!userSms.getCode().equals(sms)) {
			throw new DefinedException(ErrorCode.SMS_MISMATCHING);
		}
	}

}
