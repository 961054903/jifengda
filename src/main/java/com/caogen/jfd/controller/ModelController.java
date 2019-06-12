package com.caogen.jfd.controller;


import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.Model;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("VehicleModel")
public class ModelController {
    @Autowired
    private ModelService modelService;

    @RequestMapping("whole")
    @ResponseBody
    public Message whole(){
        Message message = new Message();
        try {
            List<Model> whole = modelService.getWhole();
            message.setData(whole);
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
     * 车辆信息
     * @return
     */

    @RequestMapping("vehicle")
    @ResponseBody
    public Message vehicle(Integer id) {
        Message message = new Message();
        try {
            Model model = modelService.getmodel(id);
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

