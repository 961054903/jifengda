package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.RewardDao;
import com.caogen.jfd.entity.driver.Reward;
import com.caogen.jfd.entity.driver.Systemm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RewardServicelmpl implements RewardService {

    @Autowired
    private RewardDao rewardDao;


    @Override
    public void create(Reward entity) {

    }

    @Override
    public void remove(Reward entity) {

    }

    @Override
    public void modify(Reward entity) {

    }

    @Override
    public Reward getById(Integer id) {
        return null;
    }

    @Override
    public List<Reward> getContent() {
        List<Reward> rewards = rewardDao.find( new Reward());
        return rewards;
    }

}
