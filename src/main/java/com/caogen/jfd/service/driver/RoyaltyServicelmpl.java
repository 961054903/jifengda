package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.RoyaltyDao;
import com.caogen.jfd.entity.driver.Royalty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoyaltyServicelmpl implements  RoyaltyService {


    @Autowired
    private RoyaltyDao royaltyDao;

    @Override
    public void create(Royalty entity) {

    }

    @Override
    public void remove(Royalty entity) {

    }

    @Override
    public void modify(Royalty entity) {

    }

    @Override
    public Royalty getById(Integer id) {
        return null;
    }


//    @Override
//    public Double getday(String phone) {
//        Royalty royalty = new Royalty();
//        royalty.setPhone(phone);
//        List<Royalty> zz = royaltyDao.find(royalty);
//        Double aa = 0.0;
//        for (int i = 0; i < zz.size(); i++) {
//            Double ss = zz.get(i).getBonus();
//            aa += ss;
//        }
//        return  aa;
//
//    }



}
