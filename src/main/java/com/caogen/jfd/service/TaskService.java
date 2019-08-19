package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.Task;

public interface TaskService extends BaseService<Task> {

  void getalready(Integer id, String code ,String serial);


}
