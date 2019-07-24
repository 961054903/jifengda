package com.caogen.jfd.dao.driver;


import com.caogen.jfd.dao.user.BaseDao;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;

public interface PeservationDao extends BaseDao<Peservation> {

 Peservation findput(Peservation peservation);

    Peservation find1(Personal personal);

  Peservation getdsp(Peservation peservation);

    Peservation get1(Peservation peservation);

    Peservation getss(Peservation peservation);

    Peservation get6(Peservation peservation);

    void delete(Peservation peservation);

    List<Peservation> find8(Peservation peservation);

    Peservation get8(Peservation peservation);

    void update1(Peservation peservation);

    Peservation get11(String code);
}
