package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.AppDriverDao;
import com.caogen.jfd.dao.driver.CompleteDao;
import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.Complete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;


@Service
public class CompleteServicelmpl implements CompleteService {

    @Autowired
    private AppDriverDao appDriverDao;
    @Autowired
    private CompleteDao completeDao;
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
    public List<Complete> getto(String phone) {
        AppDriver appDriver = new AppDriver();
        Complete complete = new Complete();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        complete.setDriver_id(id);
        List<Complete> completes = completeDao.find1(complete);
        return completes;
    }

    @Override
    public List<Complete> getmon(String phone) {
        AppDriver appDriver = new AppDriver();
        Complete complete = new Complete();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        complete.setDriver_id(id);
        List<Complete> completes = completeDao.find2(complete);
        return completes;
    }

    @Override
    public List<Complete> gethistory(String phone, String start, String end) throws ParseException {
        AppDriver appDriver = new AppDriver();
        Complete complete = new Complete();
        appDriver.setDriverphone(phone);
        Integer id = appDriverDao.get(appDriver).getId();
        complete.setDriver_id(id);
        List<Complete> completes = completeDao.find3(complete);
        System.out.println(completes);
        for(int i = 0;i<completes.size();i++){
            LocalDateTime SS = completes.get(i).getFinish_date();
            Long newss = SS.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //开始
            Date date = sdf.parse(start);
            //结束
            Date date1 = sdf.parse(end);
            if (date.getTime() >= newss && newss <= date1.getTime()){

            }else {
                completes.remove(i);
            }
        }
        return completes;
    }
}
