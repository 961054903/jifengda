package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
import com.caogen.jfd.util.FormatUtils;

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
	public Message edit(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserInfo info = Constants.gson.fromJson((String) data.getData(), AppUserInfo.class);
			info.setUser_id(user.getId());
			if (!StringUtils.isEmpty(info.getBirth())) {
				info.setBirthday(FormatUtils.strToDate(info.getBirth()));
			}
			infoService.modify(info);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.INFO_ERROR);
			StaticLogger.error("user info edit error", e);
		}
		return message;
	}

	/**
	 * 实名认证
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "real", "api/real" })
	public Message real(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserInfo entity = new AppUserInfo();
			entity.setUser_id(user.getId());
			if (infoService.getOne(entity).getIs_real()) {
				// TODO
				throw new RuntimeException("已实名认证");
			} else {
				AppUserInfo info = Constants.gson.fromJson((String) data.getData(), AppUserInfo.class);
				info.setUser_id(user.getId());
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
	public Message one(Message data) {
		Message message = new Message();
		try {
			AppUser user = userService.getByToken(data.getDesc());
			AppUserInfo info = new AppUserInfo();
			info.setUser_id(user.getId());
			AppUserInfo entity = infoService.getOne(info);
			message.setData(entity, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.INFO_ERROR);
			StaticLogger.error("user info get one error", e);
		}
		return message;
	}

}
