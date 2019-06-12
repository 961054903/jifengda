package com.caogen.jfd.controller;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.IssueFaq;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("problem")
public class ProblemController  {

    /**
     * 查看全部问题
     */

    @Autowired
    private ProblemService problemService;
    @ResponseBody
    @RequestMapping("number")
    public Message number() {
        Message message = new Message();
        try {
            List<IssueFaq> cities = problemService.getfag();
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

    @ResponseBody
    @RequestMapping("single")
    public Message single(Integer id){
        Message message = new Message();
        try {
            IssueFaq issueFaq = problemService.getSingle(id);
            message.setData(issueFaq);
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
