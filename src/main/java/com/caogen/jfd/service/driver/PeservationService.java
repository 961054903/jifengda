package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface PeservationService extends BaseService<Peservation> {
   List<Peservation> getmake(Integer driver_id, Peservation.Mode mode);

   /**
    * 获取订单详情
    * @param
    * @return7
    */
   Peservation getma(String code);


    void getput();

    boolean getspike(Integer driver_id, String code);

    void getfenjie(String code);

    void gettake(Integer id, String code);

   List <Peservation> gettui();

    void getsingle(Integer id, String code);
}
