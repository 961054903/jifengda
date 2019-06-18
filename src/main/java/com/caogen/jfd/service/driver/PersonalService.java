package com.caogen.jfd.service.driver;

import java.util.List;

import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.service.BaseService;

public interface PersonalService extends BaseService<Personal> {
    /**
     *获取上下线状态
     * @param phone
     * @return
     */
    Personal getss(String phone);

    /**
     * 接收上下线状态
     * @param is_online
     * @param phone
     */
    void getstate(Boolean is_online ,String phone);

    /**
     * 个人信息四条
     * @param phone
     * @return
     */
    Personal getmany(String phone);

    /**
     * 获取个人全部信息
     * @param phone
     * @return
     */
    Personal getwhole(String phone);



}
