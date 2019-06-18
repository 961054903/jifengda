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

	@ResponseBody
	@RequestMapping(value = { "edit", "api/edit" })
	public Message edit(String data) {
		Message message = new Message();
		try {
			AppUserInfo info = Constants.gson.fromJson(data, AppUserInfo.class);
			infoService.remove(info);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.INFO_ERROR.getCode());
			message.setDesc(ErrorCode.INFO_ERROR.getDesc());
			StaticLogger.error("user info del error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(String data) {
		Message message = new Message();
		try {
			AppUserInfo info = Constants.gson.fromJson(data, AppUserInfo.class);
			AppUser user = userService.getByUsername(info.getPhone());
			AppUserInfo entity = infoService.getOne(info);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.INFO_ERROR.getCode());
			message.setDesc(ErrorCode.INFO_ERROR.getDesc());
			StaticLogger.error("user info del error", e);
		}
		return message;
	}

}
