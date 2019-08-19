package com.caogen.jfd.service;

import com.caogen.jfd.entity.User;

public interface UserService  extends BaseService<User> {
    /**
     * 订单获取用户信息
     * @param code
     * @return
     */
    User getuser(String code);
}
