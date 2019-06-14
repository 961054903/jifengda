package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.ModelDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.driver.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonalServicelmpl implements PersonalService {
    @Autowired
    private PersonalDao personalDao;

    @Autowired
    private ModelDao modelDao;
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
    

}
