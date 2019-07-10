package com.caogen.jfd.service.driver;


import com.caogen.jfd.dao.driver.*;

import com.caogen.jfd.entity.driver.*;

import com.caogen.jfd.util.FormatUtils;
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
    @Autowired
    private ModelDao modelDao;




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
        Model model = new Model();
        jinji  k =new jinji();
        personal.setUser_id(user_id);
        model.setId(user_id);
        Personal personalDao2 = personalDao.get2(personal);
        Model modelDao3 = modelDao.get3(model);
        String contacts_gender = personalDao2.getContacts_gender();
        String contacts_name = personalDao2.getContacts_name();
        String contacts_phone = personalDao2.getContacts_phone();
        String contacts_relation = personalDao2.getContacts_relation();
        k.setContacts_gender(contacts_gender);
        k.setContacts_name(contacts_name);
        k.setContacts_phone(contacts_phone);
        k.setContacts_relation(contacts_relation);
        personalDao2.setModel(modelDao3);
        personalDao2.setUrgent(k);
        String s = FormatUtils.dateToStr(personalDao2.getBirthday());
        personalDao2.setAge(s);


        personalDao2.setUser_id(null);
        personalDao2.setBirthday(null);
        personalDao2.setContacts_gender(null);
        personalDao2.setContacts_name(null);
        personalDao2.setContacts_phone(null);
        personalDao2.setContacts_relation(null);
      return personalDao2;
    }

    @Override
    public void getmodify(Personal cities) {
        personalDao.update1(cities);
    }
    @Override
    public Personal  getchampion() {
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
        Double qq =0.0;
        for(int i = 0;i<complete2.size();i++){
            Double ss = complete2.get(i).getBonus();
            qq += ss;
        }
        Reward reward1 = rewardDao.get1(reward);
        Double money = reward1.getMoney();
        personalDao6.setOrder(qq);
        personalDao6.setMoney(money);
        return  personalDao6;
    }

    @Override
    public Personal getId(AppDriver driver) {
   Personal aa =  personalDao.get8();
        return aa;
    }


}
