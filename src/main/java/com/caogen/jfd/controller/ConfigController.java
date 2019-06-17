package com.caogen.jfd.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.ConfigService;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.util.IndustryHelper;

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

	/**
	 * 获取已开通的城市列表
	 * 
	 * @return
	 */
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

	/**
	 * 获取行业列表
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("industry")
	public Message industry() {
		Message message = new Message();
		try {
			message.setData(IndustryHelper.getIndustry());
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.FAIL.getCode());
			message.setDesc(ErrorCode.FAIL.getDesc());
			StaticLogger.logger().error(message.getDesc(), e);
		}
		return message;
	}

	/**
	 * 初始化行业列表
	 */
	@PostConstruct
	private void initIndustryList() {
		try {
			IndustryHelper.init();
		} catch (DocumentException e) {
			StaticLogger.logger().error("init industry list error", e);
		}
	}
}
