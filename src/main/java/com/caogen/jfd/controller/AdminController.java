package com.caogen.jfd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

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
