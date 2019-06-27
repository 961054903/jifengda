package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserInfo;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserInfoService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("info")
public class AppUserInfoController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserInfoService infoService;

	/**
	 * 编辑个人信息
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "edit", "api/edit" })
	public Message edit(String data) {
		Message message = new Message();
		try {
			AppUserInfo info = Constants.gson.fromJson(data, AppUserInfo.class);
			infoService.modify(info);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.INFO_ERROR);
			StaticLogger.error("user info edit error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "real", "api/real" })
	public Message real(String data) {
		Message message = new Message();
		try {
			AppUserInfo info = Constants.gson.fromJson(data, AppUserInfo.class);
			AppUserInfo entity = infoService.getOne(new AppUserInfo(info.getPhone()));
			if (entity.getIs_real()) {
				throw new RuntimeException("已实名认证");
			} else {
				info.setIs_real(true);
				infoService.modify(info);
			}
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.INFO_ERROR);
			StaticLogger.error("user info real error", e);
		}
		return message;
	}

	/**
	 * 获取个人信息
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(String data) {
		Message message = new Message();
		try {
			AppUserInfo info = Constants.gson.fromJson(data, AppUserInfo.class);
			AppUser user = userService.getByPhone(info.getPhone());
			AppUserInfo entity = infoService.getOne(info);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.INFO_ERROR);
			StaticLogger.error("user info get one error", e);
		}
		return message;
	}

}
