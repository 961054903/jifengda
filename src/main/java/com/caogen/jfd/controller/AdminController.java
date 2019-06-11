package com.caogen.jfd.controller;

import org.springframework.stereotype.Controller;

@Controller
<<<<<<< HEAD
public class AdminController {

=======
public class AdminController{
	@ResponseBody
	@RequestMapping("test")
	public String test() {
		return "success";
	}
>>>>>>> 5b4be224a87d43b60fdbe55fb41284a4457288e4
}
