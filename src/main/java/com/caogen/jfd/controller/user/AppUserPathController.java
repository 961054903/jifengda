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
	public Message add(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserPath path = Constants.gson.fromJson((String) data.getData(), AppUserPath.class);
			path.setUser_id(user.getId());
//			path.setOrigin(Constants.gson.toJson(path.getOrigin_obj()));
//			path.setDestination(Constants.gson.toJson(path.getDestination_obj()));
			pathService.create(path);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error(message.getDesc(), e);
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
			StaticLogger.error(message.getDesc(), e);
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
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "one", "api/one" })
	public Message one(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserPath path = Constants.gson.fromJson((String) data.getData(), AppUserPath.class);
			AppUserPath entity = pathService.getOne(path);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "all", "api/all" })
	public Message all(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserPath path = new AppUserPath();
			path.setUser_id(user.getId());
			List<AppUserPath> list = pathService.getAll(path);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping(value = { "count", "api/count" })
	public Message count(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserPath path = new AppUserPath();
			path.setUser_id(user.getId());
			Integer num = pathService.count(path);
			message.setData(num, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.PATH_ERROR);
			StaticLogger.error(message.getDesc(), e);
		}
		return message;
	}

}
