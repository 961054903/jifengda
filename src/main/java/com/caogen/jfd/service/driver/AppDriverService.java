package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.user.AppUser;
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
    /**
     * 根据token查询
     *
     * @param token
     * @return
     */
    AppDriver getByToken(String token);


    AppDriver getByPhone(String phone);



    String[] exchange(String result, String phone) throws Exception;

    void changePassword(String driverphone, String password);
}
