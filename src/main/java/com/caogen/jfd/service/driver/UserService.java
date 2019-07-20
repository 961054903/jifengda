package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.User;
import com.caogen.jfd.service.BaseService;

public interface UserService  extends BaseService<User> {
    /**
     * 订单获取用户信息
     * @param code
     * @return
     */
    User getuser(String code);
}
