package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.AppUser;
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




    void changePassword(String driver, String password);


    AppDriver getId(AppDriver driver);

    /**
     * 密钥交换
     *
     * @param A
     * @param token
     * @return
     * @throws Exception
     */
    String[] exchangeKe(String A, String token) throws Exception;

}
