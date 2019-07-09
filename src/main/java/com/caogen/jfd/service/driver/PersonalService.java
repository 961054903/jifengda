package com.caogen.jfd.service.driver;

import java.util.List;
import java.util.Map;

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

     * @return
     */
    Personal getmany(Integer user_id);

    /**
     * 获取个人全部信息
     * @return
     */
    Personal getwhole(Integer user_id);

    /**
     * 修改信息
     * @param cities
     * @return
     */
    void getmodify(Personal cities);

    Map<String,Object> getchampion();


    /*
    获取司机id
     */
    Personal getId(AppDriver driver);
}
