package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
