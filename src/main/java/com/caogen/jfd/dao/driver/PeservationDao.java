package com.caogen.jfd.dao.driver;


import com.caogen.jfd.dao.BaseDao;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;

public interface PeservationDao extends BaseDao<Peservation> {

    List<Peservation> findput();

    Peservation find1(Personal personal);
}
