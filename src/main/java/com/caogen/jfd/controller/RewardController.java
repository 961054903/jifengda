package com.caogen.jfd.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.Reward;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.RewardService;

@Controller
@RequestMapping("reward")
public class RewardController {
    @Autowired
    private RewardService rewardService;
    /**
     * 奖励活动
     * @return
     */

    @ResponseBody
    @RequestMapping(value = {"content","app/content"})
    public Message  content(){
        Message message  = new Message();
        try {
            List<Reward> rewards = rewardService.getContent();
            message.setData(rewards);
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
