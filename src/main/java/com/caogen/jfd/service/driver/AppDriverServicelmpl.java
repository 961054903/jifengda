package com.caogen.jfd.service.driver;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.exception.DefinedException;

import com.caogen.jfd.util.PasswordHelper;
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
            throw new DefinedException(ErrorCode.LOGIN_PARAM_ERROR);
        }
        // 用户是否存在
        AppDriver entity = appDriverDao.get(driverphone);

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

    }

    @Override
    public AppDriver getById(Integer id) {
        return null;
    }
}
