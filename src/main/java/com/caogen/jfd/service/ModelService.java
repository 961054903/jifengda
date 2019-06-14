package com.caogen.jfd.service;


import com.caogen.jfd.entity.Model;
import com.caogen.jfd.entity.Personal;

import java.util.List;

public interface ModelService extends BaseService<Model> {
    Model getModel(Integer id);
    List<Model>getWhole();

    /**
     * 获取车辆信息
     * @param id
     * @return
     */
    Model getvehicle(Integer id);
}
