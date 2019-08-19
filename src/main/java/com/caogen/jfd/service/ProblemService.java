package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.IssueFaq;

public interface ProblemService extends BaseService<IssueFaq> {
    List<IssueFaq>getfag();
    IssueFaq getSingle(Integer id);
}
