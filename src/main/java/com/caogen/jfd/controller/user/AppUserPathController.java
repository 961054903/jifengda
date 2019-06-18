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
import com.caogen.jfd.entity.user.AppUserPath;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserPathService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("path")
public class AppUserPathController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserPathService pathService;

	@ResponseBody
	@RequestMapping(value = { "add", "api/add" })
	public Message add(String data) {
		Message message = new Message();
		try {
			AppUserPath path = Constants.gson.fromJson(data, AppUserPath.class);
			pathService.create(path);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error("user path add error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "del", "api/del" })
	public Message del(String data) {
		Message message = new Message();
		try {
			AppUserPath path = Constants.gson.fromJson(data, AppUserPath.class);
			pathService.remove(path);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error("user path del error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "edit", "api/edit" })
	public Message edit(String data) {
		Message message = new Message();
		try {
			AppUserPath path = Constants.gson.fromJson(data, AppUserPath.class);
			pathService.modify(path);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error("user path edit error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(String data) {
		Message message = new Message();
		try {
			AppUserPath path = Constants.gson.fromJson(data, AppUserPath.class);
			AppUser user = userService.getByUsername(path.getPhone());
			AppUserPath entity = pathService.getOne(path);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error("user path get one error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "all", "api/all" })
	public Message all(String data) {
		Message message = new Message();
		try {
			AppUserPath path = Constants.gson.fromJson(data, AppUserPath.class);
			AppUser user = userService.getByUsername(path.getPhone());
			List<AppUserPath> list = pathService.getAll(path);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error("user path get all error", e);
		}
		return message;
	}

}
