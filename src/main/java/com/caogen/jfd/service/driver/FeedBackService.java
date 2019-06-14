package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.FeedBack;
import com.caogen.jfd.service.BaseService;


public interface FeedBackService extends BaseService<FeedBack> {


    void getProblem(FeedBack name);
}
