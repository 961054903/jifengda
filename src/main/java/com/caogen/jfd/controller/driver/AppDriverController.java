package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;

import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.service.driver.AppDriverService;
import com.caogen.jfd.util.PasswordHelper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("App")
public class AppDriverController {

    @Autowired
    private AppDriverService appDriverService;

    /**
     * 登录
     * @param driver
     * @return
     */
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
    /**
     * 退出登录
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("tuicu")
    public Message logout(String phone) {
        Message message = new Message();
        try {
            AppDriver entity = appDriverService.getByPhone(phone);
            entity.setToken(null);
            entity.setDes_key(null);
            entity.setDes_iv(null);
            appDriverService.modify(entity);
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
     * 密钥交换
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = { "signin", "app/signin" })
    public Message signin(String data) {
        Message message = new Message();
        try {
            Signin signin = new Gson().fromJson(data, Signin.class);
            String[] array = appDriverService.exchange(signin.getResult(),signin.getPhone());
            signin.setResult(array[0]);
            signin.setVerify(array[1]);
            message.setData(signin, Constants.DES_KEY, Constants.DES_IV);
        } catch (Exception e) {
            message.setErrorCode(ErrorCode.SIGNIN_ERROR);
            StaticLogger.error(message.getCode(), e);
        }
        return message;
    }

    /**
     * 修改密码
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = { "cipher", "app/cipher" })
    public Message cipher(String data) {
        Message message = new Message();
        try {
            AppDriver user = Constants.gson.fromJson(data, AppDriver.class);
            appDriverService.changePassword(user.getDriverphone(), user.getPassword());
        } catch (Exception e) {
            message.setErrorCode(ErrorCode.CIPHER_ERROR);
            StaticLogger.error(message.getCode(), e);
        }
        return message;
    }


}
