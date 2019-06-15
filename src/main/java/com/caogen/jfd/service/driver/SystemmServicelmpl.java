package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.SystemmDao;

import com.caogen.jfd.entity.driver.Reward;
import com.caogen.jfd.entity.driver.Systemm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemmServicelmpl implements SystemmService {

    @Autowired
    private SystemmDao systemmDao;



    @Override
    public void create(Systemm entity) {

    }

    @Override
    public void remove(Systemm entity) {

    }

    @Override
    public void modify(Systemm entity) {

    }

    @Override
    public Systemm getById(Integer id) {
        return null;
    }
    @Override
    public List<Systemm> getrules() {

        List<Systemm> systemms = systemmDao.find( new Systemm());
        return systemms;

    }

}
