package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserInfoService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("userinfo")
public class AppUserInfoController {
	@Autowired
	private AppUserInfoService infoService;

	@ResponseBody
	@RequestMapping(value = { "test", "api/test" })
	public String test(Message message) {
		return "SUCCEED";
	}

}
