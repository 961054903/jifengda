package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.PeservationDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Peservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PeservationServicelmpl implements PeservationService {

    @Autowired
    private PeservationDao peservationDao;
    @Autowired
    private AppDriverDao appDriverDao;


    @Override
    public void create(Peservation entity) {

    }

    @Override
    public void remove(Peservation entity) {

    }

    @Override
    public void modify(Peservation entity) {

    }

    @Override
    public Peservation getById(Integer id) {
        return null;
    }


    @Override
    public List<Peservation> getmake(String phone, Peservation.Mode mode) {
        AppDriver appDriver = new AppDriver();
        Peservation peservation = new Peservation();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        peservation.setDriver_id(id);
        peservation.setMode(mode);
        List<Peservation>peservations = peservationDao.find(peservation);
        return peservations;
    }

    @Override
    public Peservation getma(String code) {
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        return peservationDao.get(peservation);
    }




}
