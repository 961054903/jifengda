package com.caogen.jfd.dao;

import com.caogen.jfd.entity.Model;
import com.caogen.jfd.entity.Personal;

public interface ModelDao extends BaseDao<Model>  {


    /**
     * 获取车辆信息
     * @param
     * @return
     */
   Model  get3(Model id);
}
