package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Royalty;
import com.caogen.jfd.service.BaseService;

public interface RoyaltyService extends BaseService<Royalty> {

    /*
      订单提成
     */
    Royalty getroy(String code);
}
