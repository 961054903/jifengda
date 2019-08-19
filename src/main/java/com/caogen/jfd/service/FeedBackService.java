package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppDriver;
import com.caogen.jfd.entity.FeedBack;


public interface FeedBackService extends BaseService<FeedBack> {


    void getProblem(FeedBack driver_id);

    /**
     * 获取历史反馈列表
     *
     */
    List<FeedBack>getHistory(Integer driver_id);

}
