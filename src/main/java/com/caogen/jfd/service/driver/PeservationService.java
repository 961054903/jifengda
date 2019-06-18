package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface PeservationService extends BaseService<Peservation> {
   List<Peservation> getmake(String phone, Peservation.Mode mode);

   /**
    * 获取订单详情
    * @param
    * @return7
    */
   Peservation getma(String code);

    /**
     * 今日订单
     * @param
     * @return
     */
  List <Peservation> getto(String phone);

    /**
     * 本月提成
     * @param phone
     * @return
     */
    List<Peservation> getmon(String phone);
}
