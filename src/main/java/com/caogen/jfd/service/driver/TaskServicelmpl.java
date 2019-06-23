package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.TaskDao;
import com.caogen.jfd.entity.driver.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServicelmpl implements TaskService {
    @Autowired
    private TaskDao taskDao;

    @Override
    public void create(Task entity) {

    }

    @Override
    public void remove(Task entity) {

    }

    @Override
    public void modify(Task entity) {

    }

    @Override
    public Task getById(Integer id) {
        return null;
    }

    @Override
    public List <Task> getarrive(String code,String serial) {
        Task task = new Task();
        task.setCode(code);
        task.setSerial(serial);
        List<Task> tasks = taskDao.find(task);
      //  tasks.set(code).setSerial(0);
        return tasks;
    }
}
