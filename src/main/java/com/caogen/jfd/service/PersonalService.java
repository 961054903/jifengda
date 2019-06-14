package com.caogen.jfd.service;

import com.caogen.jfd.entity.Personal;

import java.util.List;

public interface PersonalService extends BaseService<Personal> {
    Personal getss(String phone);
    void getstate(Boolean is_online ,String phone);
    Personal getmany(String phone);

}
