package com.caogen.jfd.dao.driver;


import com.caogen.jfd.dao.BaseDao;
import com.caogen.jfd.entity.driver.Peservation;

import java.util.List;

public interface PeservationDao extends BaseDao<Peservation> {
    /**
     * 今天订单
     * @param peservation
     * @return
     */
    List<Peservation> find1(Peservation peservation);

    /**
     * 本月订单
     * @param peservation
     * @return
     */
    List<Peservation> find2(Peservation peservation);
}
