package com.caogen.jfd.dao;

import com.caogen.jfd.entity.Personal;

public interface PersonalDao extends BaseDao<Personal> {
    Personal get1(Personal phone);
}
