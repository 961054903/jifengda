package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.ErrorCode;

import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.service.driver.AppDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("App")
public class AppDriverController {

    @Autowired
    private AppDriverService appDriverService;


    @ResponseBody
    @RequestMapping("login")
    public Message login(AppDriver driver) {
        Message message = new Message();
        String token = null;
        try {
            token = appDriverService.passwordLogin(driver);

        message.setData(token);
        message.setCode(ErrorCode.SUCCEED.getCode());
        message.setDesc(ErrorCode.SUCCEED.getDesc());
    } catch (DefinedException e) {
        message.setCode(e.getError().getCode());
        message.setDesc(e.getError().getDesc());
        StaticLogger.error(message.getCode(), e);
    } catch (Exception e) {
        message.setCode(ErrorCode.LOGIN_ERROR.getCode());
        message.setDesc(ErrorCode.LOGIN_ERROR.getDesc());
        StaticLogger.error(message.getCode(), e);
    }
		return message;
}
}
