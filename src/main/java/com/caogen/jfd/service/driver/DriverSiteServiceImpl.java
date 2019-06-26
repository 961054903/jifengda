package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.DriverSiteDao;
import com.caogen.jfd.entity.driver.DriverSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class DriverSiteServiceImpl implements DriverSiteService {
    @Autowired
    private DriverSiteDao driverSiteDao;


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
    public void getWhole(String phone, Double longitude, Double latitude) {
        DriverSite driverSite =new DriverSite();
        LocalDateTime no =LocalDateTime.now();
        driverSite.setCreate_date(no);
        driverSite.setPhone(phone);
        driverSite.setLatitude(latitude);
        driverSite.setLongitude(longitude);
        driverSiteDao.insert(driverSite);
    }
}
