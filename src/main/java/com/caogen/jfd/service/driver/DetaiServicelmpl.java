package com.caogen.jfd.service.driver;



import com.caogen.jfd.dao.driver.DetaiDao;
import com.caogen.jfd.entity.driver.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static com.caogen.jfd.entity.driver.Detail.Operation.offline;
import static com.caogen.jfd.entity.driver.Detail.Operation.online;

@Service
public class DetaiServicelmpl implements DetaiService {

    @Autowired
    private DetaiDao detaiDao;


    @Override
    public void create(Detail entity) {

    }

    @Override
    public void remove(Detail entity) {

    }

    @Override
    public void modify(Detail entity) {

    }

    @Override
    public Detail getById(Integer id) {
        return null;
    }

    @Override
    public String getime(Integer driver_id) {
        Detail detail = new Detail();
        detail.setDriver_id(driver_id);
        List<Detail> zz = detaiDao.find(detail);
        if (zz.size()>0) {


            long aa = 0;
            if (zz.get(zz.size() - 1).getOperation().equals(online)) {
                Detail detai2 = new Detail();
                detai2.setCreate_date(LocalDateTime.now());
                detai2.setOperation(offline);
                zz.add(detai2);
            }
            for (int i = 0; i < zz.size(); i += 2) {
                LocalDateTime SS = zz.get(i).getCreate_date();
                LocalDateTime AA = zz.get(i + 1).getCreate_date();
                Long newSecond1 = SS.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                Long newSecond2 = AA.toInstant(ZoneOffset.of("+8")).toEpochMilli();
                Long a = newSecond2 - newSecond1;
                aa += a;
            }

            long hours = aa / 1000 / 60;
            String s = Long.toString(hours);
            return s;
        }

     return null;
    }
}
