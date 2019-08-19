package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.RewardDao;
import com.caogen.jfd.entity.Reward;
import com.caogen.jfd.service.RewardService;
import com.caogen.jfd.util.FormatUtils;
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
    public List<Reward> getContent() {
        Reward reward = new Reward();
        List<Reward> rewards = rewardDao.find(reward);
        for (Reward item : rewards) {
            item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
            item.setCreate_date(null);
        }
        return rewards;
    }

}
