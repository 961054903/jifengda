package com.caogen.jfd.controller.driver;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;

import com.caogen.jfd.common.StaticLogger;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.DriverSite;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.exception.DefinedException;
import com.caogen.jfd.model.Message;
import com.caogen.jfd.model.Signin;
import com.caogen.jfd.service.driver.AppDriverService;
import com.caogen.jfd.service.driver.DriverSiteService;
import com.caogen.jfd.service.driver.PersonalService;
import com.caogen.jfd.util.PasswordHelper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("App")
public class AppDriverController {

    @Autowired
    private AppDriverService appDriverService;
   @Autowired
   private PersonalService personalService;
    /**
     * 登录
     *
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
            AppDriver byId = appDriverService.getId(driver);
            Integer id = byId.getId();
            Map<String,Object> appDrivers = new HashMap<>();
            appDrivers.put("token",token);
            appDrivers.put("id",id);
            message.setData(appDrivers);
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
    @RequestMapping(value = {"tuicu", "app/tuicu"})
    public Message logout(Message data) {
        Message message = new Message();
        try {

            AppDriver entity =appDriverService.getByToken(data.getDesc());
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
//    /**
//     * 密钥交换
//     *
//     * @param data
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = {"signin", "app/signin"})
//    public Message signin(Message data) {
//        Message message = new Message();
//        try {
//            Signin signin = new Gson().fromJson((String) data.getData(), Signin.class);
//            String[] array = appDriverService.exchangeKe(signin.getResult(), data.getDesc());
//            signin.setResult(array[0]);
//            signin.setVerify(array[1]);
//            message.setData(signin, Constants.DES_KEY, Constants.DES_IV);
//        } catch (Exception e) {
//            message.setErrorCode(ErrorCode.SIGNIN_ERROR);
//            StaticLogger.error(message.getCode(), e);
//        }
//        return message;
//    }

    /**
     * 修改密码
     *
     * @param data
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"cipher", "app/cipher"})
    public Message cipher(Message data) {
        Message message = new Message();
        try {
            AppDriver user = Constants.gson.fromJson((String) data.getData(), AppDriver.class);
            appDriverService.changePassword(user.getDriverphone(), user.getPassword());
        } catch (Exception e) {
            message.setErrorCode(ErrorCode.CIPHER_ERROR);
            StaticLogger.error(message.getCode(), e);
        }
        return message;
    }


    /**
     * 司机经纬度
     */
    @Autowired
    private DriverSiteService driverSiteService;
    @ResponseBody
    @RequestMapping("dingwei")
    public Message dingwei(Integer driver_id, Double longitude, Double latitude) {
        Message message = new Message();
        try {
           driverSiteService.getWhole(driver_id,longitude,latitude);
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
