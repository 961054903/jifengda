package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.driver.DriverSitDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.DriverSite;
import com.caogen.jfd.entity.Personal;
import com.caogen.jfd.service.DriverSiteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DriverSiteServiceImpl implements DriverSiteService {
    @Autowired
    private DriverSitDao driverSitDao;
    @Autowired
    private PersonalDao personalDao;

    @Override
    public void create(DriverSite entity) {
    }
    @Override
    public void remove(DriverSite entity) {
    }
    @Override
    public void modify(DriverSite entity) {
    }
    @Override
    public DriverSite getById(Integer id) {
        return null;
    }


    @Override
    public void getWhole(Integer driver_id, Double longitude, Double latitude) {
        DriverSite driverSite =new DriverSite();
        Personal personal = new Personal();
        personal.setUser_id(driver_id);
        personal.setLongitude(longitude);
        personal.setLatitude(latitude);
        LocalDateTime no =LocalDateTime.now();
        driverSite.setCreate_date(no);
        driverSite.setDriver_id(driver_id);
        driverSite.setLatitude(latitude);
        driverSite.setLongitude(longitude);
        driverSitDao.insert(driverSite);
        personalDao.update2(personal);
    }



}
