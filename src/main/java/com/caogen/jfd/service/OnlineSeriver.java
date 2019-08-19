package com.caogen.jfd.service;

import com.caogen.jfd.entity.Online;

public interface OnlineSeriver  extends BaseService<Online> {
    void in(Integer driver_id, Online.Operation operation);
}
