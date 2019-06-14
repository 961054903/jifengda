package com.caogen.jfd.dao;

import com.caogen.jfd.entity.Personal;

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


}
