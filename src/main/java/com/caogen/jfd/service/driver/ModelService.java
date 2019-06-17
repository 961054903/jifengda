package com.caogen.jfd.service.driver;


import java.util.List;

import com.caogen.jfd.entity.driver.Model;
import com.caogen.jfd.entity.driver.Personal;
import com.caogen.jfd.service.BaseService;

public interface ModelService extends BaseService<Model> {
    Model getModel(Integer id);
    List<Model>getWhole();

    /**
     * 获取车辆信息
     * @param
     * @return
     */
    Model getvehicle(String phone);
}
