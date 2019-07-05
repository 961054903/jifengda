package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.ModelDao;
import com.caogen.jfd.dao.driver.PersonalDao;
import com.caogen.jfd.entity.driver.IssueFaq;
import com.caogen.jfd.entity.driver.Model;
import com.caogen.jfd.entity.driver.Personal;

import com.caogen.jfd.entity.driver.Vehicle;
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
    public Model getModel(Integer driver_id) {
        Vehicle vehicle = new Vehicle();

        vehicle.setDriver_id(driver_id);
        return modelDao.get(vehicle);

    }


    @Override
    public List<Model> getWhole() {
        List<Model> issueFaq = modelDao.find( new Model());
        return issueFaq;
    }


    @Override
    public Model getvehicle(Integer user_id) {
        Model model = new Model();
        Personal personal = new Personal();
        personal.setUser_id(user_id);
        model.setId(personalDao.get2(personal).getId());
        return modelDao.get3(model);

    }

}
