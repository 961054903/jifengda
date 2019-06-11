package com.caogen.jfd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.ConfigService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("config")
public class ConfigController {
	@Autowired
	private ConfigService configService;

	@ResponseBody
	@RequestMapping("city")
	public Message city() {
		Message message = new Message();
		try {
			List<String> cities = configService.getCities();
			message.setData(cities);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.FAIL.getCode());
			message.setDesc(ErrorCode.FAIL.getDesc());
			StaticLogger.logger().error(message.getDesc(), e);
		}
		return message;
	}
}
