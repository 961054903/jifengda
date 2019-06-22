package com.caogen.jfd.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.user.AppUserIssueService;
import com.caogen.jfd.service.user.AppUserService;

/**
 * 
 * @author Spuiln
 *
 */
@Controller
@RequestMapping("issue")
public class AppUserIssueController {
	@Autowired
	private AppUserService userService;
	@Autowired
	private AppUserIssueService issueService;

	/**
	 * 获取FAQ列表
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("faq")
	public Message faq() {
		Message message = new Message();
		try {
			List<AppUserIssue> list = issueService.getFAQ();
			message.setData(list);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ISSUE_ERROR);
			StaticLogger.error("get FAQ list error", e);
		}
		return message;
	}

	/**
	 * 提交反馈
	 * 
	 * @param issue
	 * @return
	 */
	@ResponseBody
	@RequestMapping("feedback")
	public Message feedback(AppUserIssue issue) {
		Message message = new Message();
		try {
			issueService.create(issue);
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ISSUE_ERROR);
			StaticLogger.error("feedback error", e);
		}
		return message;
	}

	/**
	 * 查询历史反馈
	 * 
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "history", "api/history" })
	public Message history(String data) {
		Message message = new Message();
		try {
			AppUserIssue issue = Constants.gson.fromJson(data, AppUserIssue.class);
			AppUser user = userService.getByPhone(issue.getPhone());
			List<AppUserIssue> list = issueService.getHistory(issue);
			message.setData(list, user.getDes_key(), user.getDes_iv());
		} catch (Exception e) {
			message.setErrorCode(ErrorCode.ISSUE_ERROR);
			StaticLogger.error("get history feedback list error", e);
		}
		return message;
	}
}
