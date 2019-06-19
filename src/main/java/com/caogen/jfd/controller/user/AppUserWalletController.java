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
import com.caogen.jfd.entity.user.AppUserDetail;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserDetailService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
public class AppUserWalletController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserDetailService detailService;

	@ResponseBody
	@RequestMapping(value = { "detail/all", "detail/api/all" })
	public Message all(String data) {
		Message message = new Message();
		try {
			AppUserDetail detail = Constants.gson.fromJson(data, AppUserDetail.class);
			AppUser user = userService.getByUsername(detail.getPhone());
			List<AppUserDetail> list = detailService.getAll(detail.getPhone());
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.DETAIL_ERROR);
			StaticLogger.error("user path get all error", e);
		}
		return message;
	}

}
