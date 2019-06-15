package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.service.BaseService;

public interface AppDriverService extends BaseService<AppDriver> {

    /**
     * 用户名+密码登录
     *
     * @param
     * @return token
     * @throws Exception
     */
    String passwordLogin(AppDriver driver) throws Exception;


    /**
     * 生成token
     *
     * @param
     * @return
     */
    String generateToken(String driver);

}
