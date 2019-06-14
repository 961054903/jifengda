package com.caogen.jfd.controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.model.LoginMessage;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AdminService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private AppUserService appUserService;

	@ResponseBody
	@RequestMapping(value = "sms", method = RequestMethod.POST)
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
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Message login(LoginMessage entity) {
		Message message = new Message();
		try {
			AppUser user = appUserService.getByUsername(entity.getUsername());
			switch (entity.getMode()) {
			case password:
				// 密码登录：用户不存在则抛出异常，存在则对比密码是否正确
				if (user == null) {
					throw new RuntimeException("用户不存在");
				}
				adminService.verifyPassword(entity.getUsername(), entity.getPassword());
				break;
			case sms:
				// 短信验证码登录：对比验证码是否正确，正确则登录成功，错误则抛出异常；若用户不存在，创建用户
//				adminService.verifySms(entity.getUsername(), entity.getSms());
				if (user == null) {
					adminService.createAppUser(entity.getUsername(), entity.getReferrer());
				}
				break;
			case third:
				// 第三方应用授权登录：同短信验证码登录
//				adminService.verifySms(entity.getUsername(), entity.getSms());
				if (user == null) {
					adminService.createAppUser(entity.getThirdparty(), entity.getIdentifier(), entity.getPortrait_url(),
							entity.getUsername(), entity.getReferrer());
				}
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
