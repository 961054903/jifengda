package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.FeedBackDao;
import com.caogen.jfd.entity.driver.FeedBack;

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
    public void getProblem(FeedBack name) {
        LocalDateTime no =LocalDateTime.now();
        name.setCreate_date(no);
      feedBackDao.insert(name);

    }

    @Override
    public List<FeedBack> getHistory(FeedBack entity) {
            List<FeedBack> list = feedBackDao.find(entity);
            for (FeedBack item : list) {
                item.setCreateDate(FormatUtils.dateToStr(item.getCreate_date()));
                item.setCreate_date(null);
            }
            return list;
        }
}
