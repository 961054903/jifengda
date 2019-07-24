package com.caogen.jfd.service.driver;

import java.util.List;

import com.caogen.jfd.entity.driver.IssueFaq;
import com.caogen.jfd.service.BaseService;

public interface ProblemService extends BaseService<IssueFaq> {
    List<IssueFaq>getfag();
    IssueFaq getSingle(Integer id);
}
