package com.caogen.jfd.controller;


import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.FeedBack;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.FeedBackService;
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
    private FeedBackService feedbackService;
    @RequestMapping("problem")
    @ResponseBody
    public Message problem( FeedBack name){

        Message message = new Message();
        try {

            feedbackService.getProblem(name);
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
