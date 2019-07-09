package com.caogen.jfd.service.driver;


import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.dao.driver.PersonalDao;

import com.caogen.jfd.dao.driver.RewardDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.entity.driver.Personal;

import com.caogen.jfd.entity.driver.Reward;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PersonalServicelmpl implements PersonalService {
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private CompleteDao completeDao;

    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private RewardDao rewardDao;




    @Override
    public void create(Personal entity) {

    }

    @Override
    public void remove(Personal entity) {

    }

    @Override
    public void modify(Personal entity) {

    }

    @Override
    public Personal getById(Integer id) {
        return null;
    }

    @Override
    public Personal getss(Integer user_id) {
        Personal personal = new Personal();
        personal.setUser_id(user_id);
        return  personalDao.get(personal);
    }

    @Override
    public void getstate(Boolean is_online ,Integer user_id) {
        Personal personal = new Personal();
        personal.setUser_id(user_id);
        if (is_online) {
            personal.setIs_online(true);
        } else {
            personal.setIs_online(false);
        }
        personalDao.update(personal);

    }

    @Override
    public Personal getmany(Integer user_id) {
        Personal personal = new Personal();
        personal.setUser_id(user_id);
        return personalDao.get1(personal);
    }

    @Override
    public Personal getwhole(Integer user_id) {
        Personal personal = new Personal();
        personal.setUser_id(user_id);
        return  personalDao.get2(personal);
    }

    @Override
    public void getmodify(Personal cities) {
        personalDao.update1(cities);
    }
    @Override
    public Map<String,Object>  getchampion() {
        Map<String,Object>aa =new HashMap<>();
            AppDriver appDriver = new AppDriver();
            Personal personal = new Personal();
            Reward reward =new Reward();
             Complete complete =new Complete();
            List<Complete> completes = completeDao.find4();
            Complete complete1 = completes.get(0);
            Integer driver_id = complete1.getCc();
            personal.setUser_id(driver_id);
            complete.setDriver_id(driver_id);
            //用户信息
        Personal personalDao6 = personalDao.get6(personal);
       List <Complete> complete2 = completeDao.find5(complete);
        Double cc =0.0;
        for(int i = 0;i<complete2.size();i++){
            Double ss = complete2.get(i).getBonus();
            cc += ss;
        }
        Reward reward1 = rewardDao.get1(reward);

        aa.put("information",personalDao6);
        aa.put("oreder",cc);
        aa.put("reward",reward1);
        return  aa;
    }

    @Override
    public Personal getId(AppDriver driver) {
   Personal aa =  personalDao.get8();
        return aa;
    }


}
