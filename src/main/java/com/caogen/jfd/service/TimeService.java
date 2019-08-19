package com.caogen.jfd.service;

import com.caogen.jfd.entity.Time;

public interface TimeService extends BaseService<Time> {
    Time gettime(String phone,String time);

}
