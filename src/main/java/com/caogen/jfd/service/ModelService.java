package com.caogen.jfd.service;


import com.caogen.jfd.entity.Model;

import java.util.List;

public interface ModelService extends BaseService<Model> {
    Model getmodel(Integer id);
    List<Model>getWhole();
}
