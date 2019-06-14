package com.caogen.jfd.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.model.LoginMessage;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AdminService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("user")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@ResponseBody
	@RequestMapping("sms")
	public Message sms(String phone) {
		Message message = new Message();
		try {
			adminService.generateSms(phone);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			StaticLogger.error("get sms code error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("login")
	public Message login(LoginMessage entity) {
		Message message = new Message();
		try {
			switch (entity.getMode()) {
			case password:
				adminService.passwordLogin(entity.getUsername(), entity.getPassword());
				break;
			case sms:
				adminService.smsLogin(entity.getUsername(), entity.getSms(), entity.getReferrer());
				break;
			case third:
				adminService.thirdpartyLogin(entity.getThirdparty(), entity.getIdentifier(), entity.getPortrait_url(),
						entity.getUsername(), entity.getSms(), entity.getReferrer());
				break;
			default:
				throw new RuntimeException("登录方式有误");
			}
			String token = adminService.generateToken(entity.getUsername());
			message.setData(token);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			// TODO: handle exception
			message.setCode(ErrorCode.LOGIN_ERROR.getCode());
			message.setDesc(e.getMessage());
			StaticLogger.error("login error", e);
		}
		return message;
	}

	@RequestMapping("api")
	public void api(HttpServletRequest request, HttpServletResponse response) {
		try {
			// String type = request.getParameter("type");
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
