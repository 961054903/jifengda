package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.driver.FeedBackDao;
import com.caogen.jfd.entity.FeedBack;
import com.caogen.jfd.service.FeedBackService;
import com.caogen.jfd.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private  FeedBackDao feedBackDao;
    @Override
    public void create(FeedBack entity) {

    }

    @Override
    public void remove(FeedBack entity) {

    }

    @Override
    public void modify(FeedBack entity) {

    }

    @Override
    public FeedBack getById(Integer id) {
        return null;
    }

    @Override
    public void getProblem(FeedBack driver_id) {
        LocalDateTime no =LocalDateTime.now();
        driver_id.setCreate_date(no);
      feedBackDao.insert(driver_id);

    }

    @Override
    public List<FeedBack> getHistory(Integer driver_id) {
            FeedBack feedBack = new FeedBack();
            feedBack.setDriver_id(driver_id);
            List<FeedBack> list = feedBackDao.find(feedBack);
            for (FeedBack item : list) {
                item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
                item.setCreate_date(null);
            }
            return list;
        }
}
