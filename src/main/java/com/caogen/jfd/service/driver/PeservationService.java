package com.caogen.jfd.service.driver;


import com.caogen.jfd.entity.driver.Peservation;
import com.caogen.jfd.entity.driver.Task;
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

    void  getput(String code,String flag);

    boolean getspike(Integer driver_id, String code);

    void getfenjie(String code);

   List <Peservation> gettui();

    void getsingle(Integer id, String code);

    List<Task> taskInfoList(String code);

    void completeOrder(String code,Integer taskId);
}
