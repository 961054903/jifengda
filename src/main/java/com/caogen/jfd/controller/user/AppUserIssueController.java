package com.caogen.jfd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.caogen.jfd.service.user.AppUserIssueService;

@Controller
public class AppUserIssueController {
	@Autowired
	private AppUserIssueService issueService;

}
