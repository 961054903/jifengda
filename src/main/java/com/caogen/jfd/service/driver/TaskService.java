package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Task;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface TaskService extends BaseService<Task> {
  void getarrive(String code,String serial);

    void getpei(String code, String serial);

  void getda(String code, String serial);
}
