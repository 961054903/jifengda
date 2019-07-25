package com.caogen.jfd.service.driver;
import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.dao.driver.OnlineDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.dao.driver.PriceDao;
import com.caogen.jfd.entity.driver.Online;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Time;
import com.caogen.jfd.entity.driver.price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.caogen.jfd.entity.driver.Online.Operation.online;

@Service
public class OnlineSeriverlmpl implements OnlineSeriver {
    @Autowired
    private OnlineDao onlineDao;
    @Autowired
    private PersonalDao personalDao;
    @Autowired
    private PriceDao priceDao;

    @Override
    public void in(Integer driver_id, Online.Operation operation) {
        Online online1 =new Online();
        Personal personal = new Personal();
        personal.setUser_id(driver_id);
        online1.setDriver_id(driver_id);
        online1.setOperation(operation);
        System.out.println(personal);
        price price = priceDao.get1();
        LocalTime work_start = price.getWork_start();
        LocalTime work_end = price.getWork_end();
        LocalTime time2 = LocalTime.now();
        Online.Operation operation1 = online1.getOperation();
        online1.setCreate_date(LocalDateTime.now());
        if (time2.isAfter(work_start) && time2.isBefore(work_end)) {
            if (operation1.equals(online)) {
                personal.setIs_online(true);
            } else {
                personal.setIs_online(false);
            }
            personalDao.update(personal);
            onlineDao.insert(online1);
        }else {
        throw new RuntimeException();
        }

    }

    @Override
    public void create(Online entity) {

    }

    @Override
    public void remove(Online entity) {

    }

    @Override
    public void modify(Online entity) {

    }

    @Override
    public Online getById(Integer id) {
        return null;
    }
}
