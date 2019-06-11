package com.caogen.jfd.controller;


import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("vehicle")
public class VehicleController {
    @Autowired
    private ModelService modelService;

    @ResponseBody
    @RequestMapping("vehicle")
    public Message vehicle() {
        Message message = new Message();
        try {
            List<String> model = modelService.getmodel();
            message.setData(model);
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

