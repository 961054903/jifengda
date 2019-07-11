package com.caogen.jfd.controller.driver;


import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.FeedBack;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserIssue;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.AppDriverService;
import com.caogen.jfd.service.driver.FeedBackService;

import com.caogen.jfd.service.user.AppUserIssueService;
import com.caogen.jfd.service.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("VehicleModel")
public class FeedbackController {

    @Autowired
    private AppUserService userService;
    @Autowired
    private AppUserIssueService issueService;

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
    @RequestMapping(value = { "history", "app/history" })
    public Message history(Message data) {
        Message message = new Message();
        try {
            AppUser user = userService.getByToken(data.getDesc());
            AppUserIssue issue = new AppUserIssue();
            issue.setPhone(user.getPhone());
            List<AppUserIssue> list = issueService.getHistory(issue);
            message.setData(list, user.getDes_key(), user.getDes_iv());
        } catch (Exception e) {
            message.setErrorCode(ErrorCode.FAIL);
            StaticLogger.error(message.getDesc(), e);
        }
        return message;
    }
}
