package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompleteServicelmpl implements CompleteService {

    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private CompleteDao completeDao;
    @Override
    public void create(Complete entity) {

    }

    @Override
    public void remove(Complete entity) {

    }

    @Override
    public void modify(Complete entity) {

    }

    @Override
    public Complete getById(Integer id) {
        return null;
    }

    @Override
    public List<Complete> getto(String phone) {
        AppDriver appDriver = new AppDriver();
        Complete complete = new Complete();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        complete.setDriver_id(id);
        List<Complete> completes = completeDao.find1(complete);
        return completes;
    }

    @Override
    public List<Complete> getmon(String phone) {
        AppDriver appDriver = new AppDriver();
        Complete complete = new Complete();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        complete.setDriver_id(id);
        List<Complete> completes = completeDao.find2(complete);
        return completes;
    }
}
