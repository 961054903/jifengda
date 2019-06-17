package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.PronlemDao;
import com.caogen.jfd.entity.SysConfig;
import com.caogen.jfd.entity.driver.IssueFaq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ProblemServicelmpl implements ProblemService {
    @Autowired
    private PronlemDao pronlemDao;
    @Override
    public void create(IssueFaq entity) {

    }

    @Override
    public void remove(IssueFaq entity) {

    }

    @Override
    public void modify(IssueFaq entity) {

    }

    @Override
    public IssueFaq getById(Integer id) {
        return null;
    }


    @Override
    public List<IssueFaq> getfag() {
       List<IssueFaq> issueFaq = pronlemDao.find( new IssueFaq());
        return issueFaq;
    }

    @Override
    public IssueFaq getSingle(Integer id) {
        IssueFaq issueFaq = new IssueFaq();
        issueFaq.setId(id);
        return  pronlemDao.get(issueFaq);
    }
}
