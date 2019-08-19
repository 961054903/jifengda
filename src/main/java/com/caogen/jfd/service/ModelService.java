package com.caogen.jfd.service;


import java.util.List;

import com.caogen.jfd.entity.Model;
import com.caogen.jfd.entity.Personal;

public interface ModelService extends BaseService<Model> {
//    Model getModel(Integer driver_id);
    List<Model>getWhole();

    /**
     * 获取车辆信息
     * @param
     * @return
     */
    Model getvehicle(Integer user_id);
}
