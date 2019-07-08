package com.caogen.jfd.service.driver;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.exception.DefinedException;

import com.caogen.jfd.util.PasswordHelper;
import com.caogen.jfd.util.SecretUtils;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDriverServicelmpl implements AppDriverService {

    @Autowired
    private AppDriverDao appDriverDao;


    @Override
    public String passwordLogin(AppDriver driverphone) throws Exception {
        // 检查参数
        if (driverphone.getDriverphone() == null || driverphone.getPassword() == null) {
            throw new DefinedException(ErrorCode.PARAM_MISSING);
        }
        // 用户是否存在
        AppDriver entity = appDriverDao.get(driverphone);
        System.out.println(entity);

        if (entity == null || !entity.getStatus().equals(AppDriver.Status.normal)) {
            throw new DefinedException(ErrorCode.LOGIN_USER_ERROR);
        }
        // 密码是否设置
        if (StringUtils.isEmpty(entity.getPassword())) {
            throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
        }
        // 密码是否正确
        String ciphertext = PasswordHelper.encryptPassword(driverphone.getPassword(), entity.getSalt());
        if (!ciphertext.equals(entity.getPassword())) {
            throw new DefinedException(ErrorCode.LOGIN_PASSWORD_ERROR);
        }
        return generateToken(driverphone.getDriverphone());
    }

    @Override
    public String generateToken(String driverphone) {
        String token = PasswordHelper.generateNumber();
        AppDriver driver = new AppDriver();
        driver.setDriverphone(driverphone);
        driver.setToken(token);
        appDriverDao.update(driver);
        return token;
    }

    @Override
    public void create(AppDriver entity) {

    }

    @Override
    public void remove(AppDriver entity) {

    }

    @Override
    public void modify(AppDriver entity) {
        appDriverDao.update1(entity);
    }

    @Override
    public AppDriver getById(Integer id) {
        return null;
    }


    @Override
    public AppDriver getByToken(String token) {
        AppDriver entity = new AppDriver();
        entity.setToken(token);
        return appDriverDao.get(entity);
    }


    @Override
    public AppDriver getByPhone(String phone) {
            AppDriver entity = new AppDriver();
            entity.setDriverphone(phone);
            return appDriverDao.get(entity);
        }

    @Override
    public String[] exchangeKe(String A, String token) throws Exception {
        AppDriver user = getByToken(token);
        String[] result = SecretUtils.dh(A, Constants.DH_G, Constants.DH_P);
        String B = result[0];
        String iv = result[1].substring(Constants.IV_START, Constants.IV_END);
        String key = result[1].substring(Constants.KEY_START, Constants.KEY_END);
        user.setDes_iv(iv);
        user.setDes_key(key);
        String verify = SecretUtils.desedeEncode(Constants.DES_IV, key, iv);
        modify(user);
        return new String[] { B, verify };
    }

    @Override
    public void changePassword(String driverphone, String password) {
        AppDriver user = getByPhone(driverphone);
        user.setSalt(PasswordHelper.generateSalt());
        user.setPassword(PasswordHelper.encryptPassword(password, user.getSalt()));
        modify(user);
    }

    @Override
    public AppDriver getId(AppDriver driver) {
        AppDriver appDriver = appDriverDao.get(driver);
        return appDriver;
    }

}



