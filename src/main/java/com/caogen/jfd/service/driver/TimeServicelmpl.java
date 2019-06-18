package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.TimeDao;
import com.caogen.jfd.entity.driver.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class TimeServicelmpl  implements  TimeService{
    @Autowired
    private TimeDao timeDao;


    @Override
    public void create(Time entity) {

    }

    @Override
    public void remove(Time entity) {

    }

    @Override
    public void modify(Time entity) {

    }

    @Override
    public Time getById(Integer id) {
        return null;
    }


    @Override
    public Time gettime(String phone, String time) {
        Time time1 = new Time();
        time1.setPhone(phone);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time2 = LocalDateTime.now();
        String localTime = df.format(time2);
        LocalDateTime ldt = LocalDateTime.parse("2018-01-12 17:07:05",df);
        time1.setTime(ldt);
        return  timeDao.get(time1);
    }


}
