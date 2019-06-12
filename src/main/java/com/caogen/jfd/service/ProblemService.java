package com.caogen.jfd.service;

import com.caogen.jfd.entity.IssueFaq;

import java.util.List;

public interface ProblemService extends BaseService<IssueFaq> {
    List<IssueFaq>getfag();
    IssueFaq getSingle(Integer id);
}
