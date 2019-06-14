package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.SystemmDao;

import com.caogen.jfd.entity.driver.Systemm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Systemm getrules() {
        Systemm systemm = new Systemm();
        return systemmDao.get(systemm);
    }

}
