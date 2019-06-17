package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Time;
import com.caogen.jfd.service.BaseService;

public interface TimeService extends BaseService<Time> {
    Time gettime(String phone);
}
