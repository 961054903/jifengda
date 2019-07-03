package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.RewardDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Reward;
import com.caogen.jfd.entity.driver.Systemm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RewardServicelmpl implements RewardService {

    @Autowired
    private RewardDao rewardDao;
   @Autowired
   private AppDriverDao appDriverDao;

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
    public List<Reward> getContent(String phone) {
        Reward reward = new Reward();
        reward.setPhone(phone);
        List<Reward> rewards = rewardDao.find(reward);
        return rewards;
    }

}
