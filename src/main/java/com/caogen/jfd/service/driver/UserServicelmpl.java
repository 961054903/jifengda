package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.PeservationDao;
import com.caogen.jfd.dao.driver.UserDao;
import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.entity.driver.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PeservationDao peservationDao;

    @Override
    public void create(User entity) {

    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void modify(User entity) {

    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public User getuser(String code) {
        User user = new User();
        Peservation peservation = new Peservation();
        peservation.setCode(code);
        Integer id = peservationDao.get(peservation).getUser_id();
        user.setId(id);
        return  userDao.get(user);
    }


}
