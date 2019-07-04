package com.caogen.jfd.service.driver;

import java.util.List;

import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.service.BaseService;

public interface PersonalService extends BaseService<Personal> {
    /**
     *获取上下线状态
     * @return
     */
    Personal getss(Integer user_id);

    /**
     * 接收上下线状态
     * @param is_online
     */
    void getstate(Boolean is_online ,Integer user_id);

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

    /**
     * 修改信息
     * @param cities
     * @return
     */
    void getmodify(Personal cities);

    Personal getchampion();


    /*
    获取司机id
     */
    Personal getId(AppDriver driver);
}
