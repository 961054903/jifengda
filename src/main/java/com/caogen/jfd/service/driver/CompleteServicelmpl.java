package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.driver.*;
import com.caogen.jfd.util.FormatUtils;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


@Service
public class CompleteServicelmpl implements CompleteService {

    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private CompleteDao completeDao;
    @Autowired
    private PersonalDao personalDao;

    @Override
    public void create(Complete entity) {

    }

    @Override
    public void remove(Complete entity) {

    }

    @Override
    public void modify(Complete entity) {

    }

    @Override
    public Complete getById(Integer id) {
        return null;
    }

    @Override
    public List<Complete> getto(Integer driver_id) {
        Complete complete = new Complete();
        complete.setDriver_id(driver_id);
        List<Complete> completes = completeDao.find1(complete);
        for (Complete item : completes) {
            item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
            item.setCreate_date(null);
        }
        return completes;
    }

    @Override
    public List<Complete> getmon(Integer driver_id) {
        Complete complete = new Complete();
        complete.setDriver_id(driver_id);
        List<Complete> completes = completeDao.find2(complete);
        for (Complete item : completes) {
            item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
            item.setCreate_date(null);
        }
        return completes;
    }

    @Override
    public List<Complete> gethistory(Integer driver_id, String start, String end) throws ParseException {
        Complete complete = new Complete();
        complete.setDriver_id(driver_id);
        List<Complete> completes = completeDao.find3(complete);
        for (int i = 0; i < completes.size(); ) {
            LocalDateTime SS = completes.get(i).getFinish_date();
            Long newss = SS.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //开始
            Date date = sdf.parse(start);
            //结束
            Date date1 = sdf.parse(end);
            if (newss >= date.getTime() && newss <= date1.getTime()) {
                i++; } else {
                completes.remove(i);
            }
        }
            for (Complete item : completes) {
                item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
                item.setFinishdate(FormatUtils.dateToStr(item.getFinish_date()));
                item.setCreate_date(null);
                item.setFinish_date(null);

        }
        return completes;
    }





//    @Override
//    public Complete getchampion() {
//        AppDriver appDriver = new AppDriver();
//        Complete complete = new Complete();
//        Personal personal = new Personal();
//        List<Complete> completes = completeDao.find4();
//        Complete complete1 = completes.get(0);
//        Integer driver_id = complete1.getCc();
//        appDriver.setId(driver_id);
//        AppDriver app = appDriverDao.get(appDriver);
//        String  phone =  app.getDriverphone();
//        personal.setPhone(phone);
//        personalDao.get6(personal);
//        return personal;
//    }
}
