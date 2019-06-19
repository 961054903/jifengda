package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.caogen.jfd.service.user.AppUserDetailService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
public class AppUserDetailController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserDetailService detailService;
}
