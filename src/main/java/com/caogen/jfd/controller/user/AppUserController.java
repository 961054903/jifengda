package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.LoginType;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.service.user.AppUserService;
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

	@ResponseBody
	@RequestMapping("login")
	public Message login(LoginType type, AppUser user, AppUserSms sms, AppUserThird third) {
		Message message = new Message();
		String token = null;
		try {
			switch (type) {
			case password:
				token = userService.loginByPassword(user);
				break;
			case sms:
				token = userService.loginBySms(user, sms);
				break;
			case thirdparty:
				token = userService.loginByThird(user, sms, third);
				break;
			default:
				throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
			}
			message.setData(token);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (DefinedException e) {
			message.setCode(e.getError().getCode());
			message.setDesc(e.getError().getDesc());
			StaticLogger.error(message.getCode(), e);
		} catch (Exception e) {
			message.setCode(ErrorCode.LOGIN_ERROR.getCode());
			message.setDesc(ErrorCode.LOGIN_ERROR.getDesc());
			StaticLogger.error(message.getCode(), e);
		}
		return message;
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
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
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
}
