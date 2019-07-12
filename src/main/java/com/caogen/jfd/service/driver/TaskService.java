package com.caogen.jfd.service.driver;

import com.caogen.jfd.entity.driver.Task;
import com.caogen.jfd.service.BaseService;

import java.util.List;

public interface TaskService extends BaseService<Task> {

  void getalready(Integer id, String code ,String serial);


}
