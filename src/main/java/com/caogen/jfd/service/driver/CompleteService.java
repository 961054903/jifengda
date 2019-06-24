package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Complete;

import com.caogen.jfd.service.BaseService;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;

public interface CompleteService extends BaseService<Complete> {
    /**
     * 今日订单
     * @param
     * @return
     */
    List<Complete> getto(String phone);

    /**
     * 本月提成
     * @param phone
     * @return
     */
    List<Complete> getmon(String phone);

    /**
     * 历史收入
     * @param phone
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */

    List<Complete> gethistory(String phone, String start, String end) throws ParseException;

    /**
     * 月冠军
     * @param
     * @return
     */
  //Complete getchampion();
}
