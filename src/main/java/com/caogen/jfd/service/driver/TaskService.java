package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Task;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface TaskService extends BaseService<Task> {
  void getarrive(String code,Integer status);

    void getpei(String code,Integer status);

  void getda(String code, Integer status);
}
