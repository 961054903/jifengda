package com.caogen.jfd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("appUser")
public class AppUserController {
	@Autowired
	private AppUserService appUserService;

	@ResponseBody
	@RequestMapping("login")
	public Message login() {
		Message message = new Message();
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}
}
