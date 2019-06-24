package com.caogen.jfd.service.driver;


import com.caogen.jfd.dao.driver.PersonalDao;

import com.caogen.jfd.entity.driver.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    @Override
    public Personal getwhole(String phone) {
        Personal personal = new Personal();

        personal.setPhone(phone);

        return  personalDao.get2(personal);
    }

    @Override
    public void getmodify(Personal cities) {

        personalDao.update1(cities);
    }


}
