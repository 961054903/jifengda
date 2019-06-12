package com.caogen.jfd.service;

import com.caogen.jfd.entity.FeedBack;


public interface FeedBackService extends BaseService<FeedBack> {


    void getProblem(FeedBack name);
}
