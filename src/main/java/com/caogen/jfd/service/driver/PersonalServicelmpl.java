package com.caogen.jfd.service.driver;


import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.dao.driver.ModelDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.dao.driver.PriceDao;
import com.caogen.jfd.dao.driver.RewardDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.entity.driver.Model;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Reward;
import com.caogen.jfd.entity.driver.jinji;
import com.caogen.jfd.util.FormatUtils;


@Service
public class PersonalServicelmpl implements PersonalService {
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private CompleteDao completeDao;
    @Autowired
    private PriceDao priceDao;

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
    public void getstate(Boolean is_online, Integer user_id) {

    }

//    @Override
//    public void getstate(Boolean is_online ,Integer user_id) {
//        Personal personal = new Personal();
//        personal.setUser_id(user_id);
//        price price = priceDao.get1();
//        LocalTime work_start = price.getWork_start();
//        LocalTime work_end = price.getWork_end();
//        LocalTime time2 = LocalTime.now();
//       // if (time2.isAfter(work_start) || time2.isBefore(work_end)) {
//            if (is_online) {
//                personal.setIs_online(true);
//            } else {
//                personal.setIs_online(false);
//           // }
//        }
//        personalDao.update(personal);
//    }

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
    public List<Personal>  getchampion() {
        List AAA  =new LinkedList();
        Personal personal = new Personal();
        Reward reward = new Reward();
        Complete complete = new Complete();
        List<Complete> completes = completeDao.find4();
        for (int i = 0; i < completes.size(); i++) {
            Integer driver_id = completes.get(i).getDriver_id();
            personal.setUser_id(driver_id);
            complete.setDriver_id(driver_id);
            //用户信息
            Personal personalDao6 = personalDao.get6(personal);
            List<Complete> complete2 = completeDao.find5(complete);
            int size = complete2.size();

           List <Reward> reward1 = rewardDao.find1(reward);
              Double money = reward1.get(i).getMoney();
              personalDao6.setMoney(money);
            personalDao6.setOrder(size);
            AAA.add(personalDao6);
        }
        return AAA;
    }
    @Override
    public Personal getId(AppDriver driver) {
   Personal aa =  personalDao.get8();
        return aa;
    }


}
