package com.caogen.jfd.controller;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.Personal;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("PersonalCenter")
public class PersonalController {

    @Autowired
    private PersonalService personalService;

    /**
     * 查询上下线状态全部
     * @return
     */
    @ResponseBody
    @RequestMapping("upAndDown")
    public Message upAndDown() {
        Message message = new Message();
        try {
            List<Personal> cities = personalService.getss();
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
     * 查询是否在线
     *
     */
    @ResponseBody
    @RequestMapping("state")
    public Message state(Boolean is_online, String phone)  {
        Message message = new Message();
        try {
             personalService.getstate(is_online,phone);
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
