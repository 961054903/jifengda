package com.caogen.jfd.dao.driver;

import com.caogen.jfd.dao.user.BaseDao;
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


    List<Personal> find1(Personal personal);

    Personal getdsp(Peservation peservation);

    void update2(Personal personal);


    List<Personal> find3(Personal personal);

    Personal get8();

    void update1(Personal cities);

    List<Personal> find6(Personal personal);


    Personal get6(Personal personal);
}
