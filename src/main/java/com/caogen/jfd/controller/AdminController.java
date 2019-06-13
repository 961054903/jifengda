package com.caogen.jfd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.entity.AppUser;
import com.caogen.jfd.model.LoginMessage;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.AdminService;
import com.caogen.jfd.service.AppUserService;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private AppUserService appUserService;

	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Message login(LoginMessage login) {
		Message message = new Message();
		try {
			AppUser user = appUserService.getByUsername(login.getUsername(), login.getIdentity());
			switch (login.getMode()) {
			case password:
				if (user == null) {
					throw new RuntimeException("用户不存在");
				}
				
				break;
			case sms:

				break;
			case third:

				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return message;
	}

	@RequestMapping("api")
	public void api(HttpServletRequest request, HttpServletResponse response) {
		try {
			String type = request.getParameter("type");
			request.getRequestDispatcher("test").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@ResponseBody
	@RequestMapping("test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		String data = request.getParameter("data");
		return data;
	}
}
