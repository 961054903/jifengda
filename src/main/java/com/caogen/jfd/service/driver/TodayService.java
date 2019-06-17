package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Today;
import com.caogen.jfd.service.BaseService;

public interface TodayService extends BaseService<Today> {
    Today gettoday(String phone);
}
