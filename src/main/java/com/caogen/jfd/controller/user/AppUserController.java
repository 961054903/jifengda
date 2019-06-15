package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.LoginType;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserThird;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserService;

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
	public Message login(LoginType type, AppUser user, AppUserThird third) {
		Message message = new Message();
		try {
			switch (type) {
			case password:

				break;
			case sms:

				break;
			case thirdparty:

				break;
			default:
				message.setCode(ErrorCode.LOGIN_PARAM_ERROR.getCode());
				message.setDesc(ErrorCode.LOGIN_PARAM_ERROR.getDesc());
				return message;
			}
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.LOGIN_ERROR.getCode());
			message.setDesc(ErrorCode.LOGIN_ERROR.getDesc());
			StaticLogger.error(message.getCode(), e);
		}
		return message;
	}
}
