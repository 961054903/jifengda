package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Complete;
import com.caogen.jfd.service.BaseService;

import java.text.ParseException;
import java.util.List;

public interface CompleteService extends BaseService<Complete> {
    /**
     * 今日订单
     * @param
     * @return
     */
    List<Complete> getto(Integer driver_id);

    /**
     * 本月提成
     * @return
     */
    List<Complete> getmon(Integer driver_id);

    /**
     * 历史收入
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */

    List<Complete> gethistory(Integer driver_id, String start, String end) throws ParseException;



    /**
     * 月冠军
     * @param
     * @return
     */
  //Complete getchampion();
}
