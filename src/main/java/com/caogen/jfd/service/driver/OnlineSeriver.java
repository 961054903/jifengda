package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Online;
import com.caogen.jfd.service.BaseService;

public interface OnlineSeriver  extends BaseService<Online> {
    void in(Integer driver_id, Online.Operation operation);
}
