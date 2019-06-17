package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.ModelDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.driver.IssueFaq;
import com.caogen.jfd.entity.driver.Model;
import com.caogen.jfd.entity.driver.Personal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class ModelServicelmpl implements ModelService {

    @Autowired
    private ModelDao modelDao;

    @Autowired
    private PersonalDao personalDao;


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
    public Model getModel(Integer id) {
        Model model = new Model();
        model.setId(id);
        return  modelDao.get(model);

    }




    @Override
    public List<Model> getWhole() {
        List<Model> issueFaq = modelDao.find( new Model());
        return issueFaq;
    }


    @Override
    public Model getvehicle(String phone) {
        Model model = new Model();
        Personal personal = new Personal();
        personal.setPhone(phone);
        model.setId(personalDao.get2(personal).getId());
        return modelDao.get3(model);

    }

}
