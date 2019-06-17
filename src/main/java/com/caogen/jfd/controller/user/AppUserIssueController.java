package com.caogen.jfd.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserIssueService;

@Controller
@RequestMapping("issue")
public class AppUserIssueController {
	@Autowired
	private AppUserIssueService issueService;

	@ResponseBody
	@RequestMapping("faq")
	public Message faq() {
		Message message = new Message();
		try {
			List<AppUserIssue> list = issueService.getFAQ();
			message.setData(list);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.FAIL.getCode());
			message.setDesc(ErrorCode.FAIL.getDesc());
			StaticLogger.error("get FAQ list error", e);
		}
		return message;
	}

	@ResponseBody
	@RequestMapping("feedback")
	public Message feedback(AppUserIssue issue) {
		Message message = new Message();
		try {
			issueService.create(issue);
			message.setCode(ErrorCode.SUCCEED.getCode());
			message.setDesc(ErrorCode.SUCCEED.getDesc());
		} catch (Exception e) {
			message.setCode(ErrorCode.FAIL.getCode());
			message.setDesc(ErrorCode.FAIL.getDesc());
			StaticLogger.error("feedback error", e);
		}
		return message;
	}
}
