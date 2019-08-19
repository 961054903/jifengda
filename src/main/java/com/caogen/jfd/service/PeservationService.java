package com.caogen.jfd.service;


import java.util.List;
import java.util.Map;

import com.caogen.jfd.entity.Peservation;
import com.caogen.jfd.entity.Task;

public interface PeservationService extends BaseService<Peservation> {
   List<Peservation> getmake(Integer driver_id, Peservation.Mode mode);

   /**
    * 获取订单详情
    * @param
    * @return7
    */
   Peservation getma(String code);


    void getput();

    void  getput(String code,String flag);

    boolean getspike(Integer driver_id, String code);

    void getfenjie(String code);

   List <Peservation> gettui();

    void getsingle(Integer id, String code);

    List<Task> taskInfoList(String code);

    void completeOrder(String code,Integer taskId);

    List<Map> currentOrder(Integer driverId);
}
