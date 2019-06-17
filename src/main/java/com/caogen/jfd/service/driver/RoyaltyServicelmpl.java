package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.RoyaltyDao;
import com.caogen.jfd.entity.driver.Reward;
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

    @Override
    public Royalty getroy(String code) {
        Royalty royalty = new Royalty();
        royalty.setPhone(code);
        return royaltyDao.get(royalty);
    }
}
