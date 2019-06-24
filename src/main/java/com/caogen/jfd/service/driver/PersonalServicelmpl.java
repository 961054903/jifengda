package com.caogen.jfd.service.driver;


import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.dao.driver.PersonalDao;

import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.entity.driver.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonalServicelmpl implements PersonalService {
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private CompleteDao completeDao;

    @Autowired
    private AppDriverDao appDriverDao;




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
    @Override
    public Personal getchampion() {
            AppDriver appDriver = new AppDriver();
            Complete complete = new Complete();
            Personal personal = new Personal();
            List<Complete> completes = completeDao.find4();
            Complete complete1 = completes.get(0);
            Integer driver_id = complete1.getCc();
            appDriver.setId(driver_id);
            AppDriver app = appDriverDao.get(appDriver);
            String  phone =  app.getDriverphone();
            personal.setPhone(phone);
        Personal personalDao6 = personalDao.get6(personal);
        return personalDao6;
    }


}
