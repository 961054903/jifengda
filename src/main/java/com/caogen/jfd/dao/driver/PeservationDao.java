package com.caogen.jfd.dao.driver;


import java.util.List;
import java.util.Map;

import com.caogen.jfd.entity.Personal;
import com.caogen.jfd.entity.Peservation;
import com.caogen.jfd.entity.Task;

public interface PeservationDao extends BaseDao<Peservation> {

 Peservation findput(String code);

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

    Peservation get333(String code);

    List<Task> taskInfoList(String code);

    List<Map> currentOrder(Integer driverId);
}
