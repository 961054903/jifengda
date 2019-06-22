package com.caogen.jfd.service.driver;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.controller.driver.dome.JPush;
import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.dao.driver.PeservationDao;
import com.caogen.jfd.dao.driver.VehicleDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Peservation;

import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserSite;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


@Service
public class PeservationServicelmpl implements PeservationService {


    /**
     * 地球半径,单位 km
     */
    private static final double EARTH_RADIUS = 6378.137;

    @Autowired
    private PeservationDao peservationDao;
    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private VehicleDao vehicleDao;


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
    public  Peservation getma(String code) {
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        return peservationDao.get(peservation);
    }

    @Override
    public List<Peservation> getput() {
        Personal personal = new Personal();
        //司机
        List<Personal> personalDao1 = personalDao.find1(personal);
        for (int s =0;s<=personalDao1.size();s++) {
            Double longitude1 = personalDao1.get(s).getLongitude();
            Double latitude1 = personalDao1.get(s).getLatitude();
            Integer id = vehicleDao.get1(personalDao1.get(s).getId()).getModel_id();

        //订单
            List<Peservation> peservations = peservationDao.findput();
            for (int i = 0; i <= peservations.size(); i++) {
                Integer status = peservations.get(i).getStatus();
                String origin = peservations.get(i).getOrigin();
                Integer model_id = peservations.get(i).getModel_id();
                AppUserSite appUserSite = Constants.gson.fromJson(origin,AppUserSite.class);
                Double latitude2 = appUserSite.getLatitude();
                Double longitude2 = appUserSite.getLongitude();

                if (id !=model_id){
                    continue;
                }
                if (status !=1){
                    continue;
                }
                    // 纬度
                    double lat1 = Math.toRadians(latitude1);
                    double lat2 = Math.toRadians(latitude2);
                    // 经度
                    double lng1 = Math.toRadians(longitude1);
                    double lng2 = Math.toRadians(longitude2);
                    // 纬度之差
                    double a = lat1 - lat2;
                    // 经度之差
                    double b = lng1 - lng2;
                    // 计算两点距离的公式
                    double ss = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                            Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
                    // 弧长乘地球半径, 返回单位: 千米
                    ss = ss * EARTH_RADIUS;
                    //公里自定义
                    if (ss<=5){
                    //推送

                    }
                    
            }
        }
      return  null;
    }


}
