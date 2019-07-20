package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.AppDriver;
import com.caogen.jfd.entity.driver.FeedBack;
import com.caogen.jfd.service.BaseService;

import java.util.List;


public interface FeedBackService extends BaseService<FeedBack> {


    void getProblem(FeedBack driver_id);

    /**
     * 获取历史反馈列表
     *
     */
    List<FeedBack>getHistory(Integer driver_id);

}
