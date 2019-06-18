package com.caogen.jfd.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserSiteService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("site")
public class AppUserSiteController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserSiteService siteService;

	@ResponseBody
	@RequestMapping(value = { "add", "api/add" })
	public Message add(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			siteService.create(site);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.SITE_ERROR.getCode());
			message.setDesc(ErrorCode.SITE_ERROR.getDesc());
			StaticLogger.error("user site add error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "del", "api/del" })
	public Message del(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			siteService.remove(site);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.SITE_ERROR.getCode());
			message.setDesc(ErrorCode.SITE_ERROR.getDesc());
			StaticLogger.error("", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "edit", "api/edit" })
	public Message edit(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			siteService.modify(site);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.SITE_ERROR.getCode());
			message.setDesc(ErrorCode.SITE_ERROR.getDesc());
			StaticLogger.error("", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			AppUser user = userService.getByUsername(site.getPhone());
			AppUserSite entity = siteService.getOne(site);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.SITE_ERROR.getCode());
			message.setDesc(ErrorCode.SITE_ERROR.getDesc());
			StaticLogger.error("", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "all", "api/all" })
	public Message list(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			AppUser user = userService.getByUsername(site.getPhone());
			List<AppUserSite> list = siteService.getAll(site);
			message.setData(list, user.getDes_key(), user.getDes_iv());
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.SITE_ERROR.getCode());
			message.setDesc(ErrorCode.SITE_ERROR.getDesc());
			StaticLogger.error("", e);
		}
		return message;
	}
}
