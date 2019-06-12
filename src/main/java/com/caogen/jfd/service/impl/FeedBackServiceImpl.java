package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.FeedBackDao;
import com.caogen.jfd.entity.FeedBack;
import com.caogen.jfd.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}
