package com.caogen.jfd.controller.driver;


import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.FeedBack;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.AppDriverService;
import com.caogen.jfd.service.driver.FeedBackService;

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

    /**
     * 问题反馈
     */

    @Autowired
    private FeedBackService feedbackService;

    @Autowired
    private AppDriverService appDriverService;
    @RequestMapping("problem")
    @ResponseBody
    public Message problem(FeedBack driver_id){

        Message message = new Message();
        try {

            feedbackService.getProblem(driver_id);
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
            FeedBack feedBack = Constants.gson.fromJson(data,FeedBack.class);
            AppDriver user = appDriverService.getByPhone(feedBack.getDriver_id());
            List<FeedBack> list = feedbackService.getHistory(feedBack.getDriver_id());
            message.setData(list, user.getDes_key(), user.getDes_iv());
        } catch (Exception e) {
            message.setErrorCode(ErrorCode.ISSUE_ERROR);
            StaticLogger.error("get history feedback list error", e);
        }
        return message;
    }
}
