package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.OnlineDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.driver.Online;
import com.caogen.jfd.entity.driver.Personal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OnlineSeriverlmpl implements OnlineSeriver {
    @Autowired
    private OnlineDao onlineDao;
    @Autowired
    private PersonalDao personalDao;

    @Override
    public void in(Integer driver_id, Online.Operation operation) {
        Online online =new Online();
        Personal personal = new Personal();

        personal.setUser_id(driver_id);
        online.setDriver_id(driver_id);
        online.setOperation(operation);
        online.setCreate_date(LocalDateTime.now());
        onlineDao.insert(online);

    }

    @Override
    public void create(Online entity) {

    }

    @Override
    public void remove(Online entity) {

    }

    @Override
    public void modify(Online entity) {

    }

    @Override
    public Online getById(Integer id) {
        return null;
    }
}
