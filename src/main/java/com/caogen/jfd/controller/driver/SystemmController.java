package com.caogen.jfd.controller.driver;


import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.Systemm;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.SystemmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("system")
public class SystemmController {

    @Autowired
    private SystemmService systemmService;

    /**
     * 规章制度
     * @return
     */
    @ResponseBody
    @RequestMapping("rules")
    public Message rules() {
        Message message = new Message();
        try {
           List <Systemm> system = systemmService.getrules();
            message.setData(system);
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
