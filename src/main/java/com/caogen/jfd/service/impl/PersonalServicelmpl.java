package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.PersonalDao;
import com.caogen.jfd.entity.Personal;
import com.caogen.jfd.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalServicelmpl implements PersonalService {
    @Autowired
    private PersonalDao personalDao;
    @Override
    public void create(Personal entity) {

    }

    @Override
    public void remove(Personal entity) {

    }

    @Override
    public void modify(Personal entity) {

    }

    @Override
    public Personal getById(Integer id) {
        return null;
    }

    @Override
    public Personal getss(String phone) {
        Personal personal = new Personal();
        personal.setPhone(phone);
        return  personalDao.get(personal);
    }

    @Override
    public void getstate(Boolean is_online ,String phone) {
        Personal personal = new Personal();
        personal.setPhone(phone);
        if (is_online) {
            personal.setIs_online(true);
        } else {
            personal.setIs_online(false);
        }
        personalDao.update(personal);

    }

    @Override
    public Personal getmany(String phone) {
        Personal personal = new Personal();
        personal.setPhone(phone);
        return personalDao.get1(personal);
    }
}
