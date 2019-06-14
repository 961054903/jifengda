package com.caogen.jfd.service;

import com.caogen.jfd.entity.Personal;

import java.util.List;

public interface PersonalService extends BaseService<Personal> {
    List<Personal>getss();
    void getstate(Boolean is_online ,String phone);
}
