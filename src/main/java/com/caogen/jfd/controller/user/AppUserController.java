package com.caogen.jfd.controller.user;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.LoginType;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.SysConfig;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUser.State;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.service.ConfigService;
import com.caogen.jfd.service.user.AppUserInfoService;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserSmsService;
import com.caogen.jfd.service.user.AppUserThirdService;
import com.caogen.jfd.util.PasswordHelper;
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

	@ResponseBody
	@RequestMapping("login")
	public Message login(LoginType type, AppUser user, AppUserSms sms, AppUserThird third) {
		Message message = new Message();
		String token = null;
		try {
			switch (type) {
			case password:
				token = loginByPassword(user);
				break;
			case sms:
				token = loginBySms(user, sms);
				break;
			case thirdparty:
				token = loginByThird(user, sms, third);
				break;
			default:
				throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
			}
			message.setData(token);
		} catch (DefinedException e) {
			message.setErrorCode(e.getError());
			StaticLogger.error(message.getCode(), e);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.LOGIN_ERROR);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	/**
	 * 密码登录
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private String loginByPassword(AppUser user) throws Exception {
		// 检查参数
		if (user.getUsername() == null || user.getPassword() == null) {
			throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
		}
		// 用户是否存在
		AppUser entity = userService.getByUsername(user.getUsername());
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
		return generateToken(user.getUsername());
	}

	private String loginBySms(AppUser user, AppUserSms sms) {
		// TODO Auto-generated method stub
		return null;
	}

	private String loginByThird(AppUser user, AppUserSms sms, AppUserThird third) {
		// TODO Auto-generated method stub
		return null;
	}

	@ResponseBody
	@RequestMapping(value = { "signin", "api/signin" })
	public Message signin(String data) {
		Message message = new Message();
		try {
			Signin signin = new Gson().fromJson(data, Signin.class);
			String[] array = userService.exchangeKey(signin.getResult(), signin.getPhone());
			signin.setResult(array[0]);
			signin.setVerify(array[1]);
			message.setData(signin, Constants.DEFAULT_KEY, Constants.DEFAULT_IV);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SIGNIN_ERROR);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "cipher", "api/cipher" })
	public Message cipher(String data) {
		Message message = new Message();
		try {
			AppUser user = Constants.gson.fromJson(data, AppUser.class);
			userService.changePassword(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.CIPHER_ERROR);
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}

	/**
	 * 生成token
	 * 
	 * @param username
	 * @return
	 */
	private String generateToken(String username) {
		String token = PasswordHelper.generateNumber();
		AppUser entity = new AppUser();
		entity.setUsername(username);
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
	private void verifySms(String phone, String sms) throws Exception {
		// 查询该条验证码记录
		AppUserSms entity = new AppUserSms();
		entity.setPhone(phone);
		AppUserSms userSms = smsDao.get(entity);
		if (userSms == null) {
			throw new DefinedException(ErrorCode.SMS_INEXISTENCE);
		}
		// 验证码是否在有效期内
		SysConfig config = configDao.get(new SysConfig("indate"));
		Long indate = Long.parseLong(config.getItem_value());
		Duration duration = Duration.between(userSms.getCreate_date(), LocalDateTime.now());
		if (duration.toMillis() > indate) {
			throw new DefinedException(ErrorCode.SMS_PAST);
		}
		if (!userSms.getCode().equals(sms)) {
			throw new DefinedException(ErrorCode.SMS_MISMATCHING);
		}
	}

}
