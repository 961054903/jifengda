package com.caogen.jfd.service.impl;

import com.caogen.jfd.dao.ModelDao;
import com.caogen.jfd.entity.Model;
import com.caogen.jfd.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class ModelServicelmpl implements ModelService {

    @Autowired
    private ModelDao modelDao;


    @Override
    public void create(Model entity) {

    }

    @Override
    public void remove(Model entity) {

    }

    @Override
    public void modify(Model entity) {

    }

    @Override
    public Model getById(Integer id) {
        return null;
    }
    @Override
    public List<String> getmodel() {
        Model model = new Model();
        model.setModel("id");
        model = modelDao.get(model);
        List<String> list = Arrays.asList(model.getBrand().split("|"));
        return list;
    }
}
