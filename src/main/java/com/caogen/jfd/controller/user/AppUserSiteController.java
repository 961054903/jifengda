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
import com.caogen.jfd.entity.user.SysConfig;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserService;
import com.caogen.jfd.service.user.AppUserSiteService;
import com.caogen.jfd.service.user.ConfigService;

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
	@Autowired
	private ConfigService configService;

	@ResponseBody
	@RequestMapping(value = { "add", "api/add" })
	public Message add(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			siteService.create(site);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
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
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
			StaticLogger.error("user site del error", e);
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
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
			StaticLogger.error("user site edit error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			AppUser user = userService.getByPhone(site.getPhone());
			AppUserSite entity = siteService.getOne(site);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
			StaticLogger.error("user site get one error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "all", "api/all" })
	public Message all(String data) {
		Message message = new Message();
		try {
			AppUserSite site = Constants.gson.fromJson(data, AppUserSite.class);
			AppUser user = userService.getByPhone(site.getPhone());
			List<AppUserSite> list = siteService.getAll(site);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
			StaticLogger.error("user site get all error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("location")
	public Message location(AppUserSite site, Integer model_id) {
		Message message = new Message();
		try {
			SysConfig config = configService.getByItem("scope");
			double distance = Double.valueOf(config.getItem_value());
			List<AppUserSite> list = siteService.getDriverLocation(site.getLongitude(), site.getLatitude(), distance,
					model_id);
			message.setData(list);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.SITE_ERROR);
			StaticLogger.error("user site get driver location error", e);
		}
		return message;
	}
}
