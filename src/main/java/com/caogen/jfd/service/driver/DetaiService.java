package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Detail;
import com.caogen.jfd.service.BaseService;

public interface DetaiService  extends BaseService<Detail> {
   String getime(String phone);
}
