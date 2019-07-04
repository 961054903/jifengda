package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.BaseDao;
import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;

public interface PersonalDao extends BaseDao<Personal> {

    /**
     * 获取四条个人信息
     * @param phone
     * @return
     */
    Personal get1(Personal phone);

    /**
     * 获取个人信息
     * @param phone
     * @return
     */
    Personal get2(Personal phone);

    void update1(Personal cities);

    Personal get6(Personal personal);

    List<Personal> find1(Personal personal);

    Personal getdsp(Peservation peservation);

    void update2(Personal personal);


    List<Personal> find3(Personal personal);

    Personal get8();
}
