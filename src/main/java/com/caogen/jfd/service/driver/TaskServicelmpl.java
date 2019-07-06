package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.TaskDao;
import com.caogen.jfd.entity.driver.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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
    public void getarrive(String code,Integer status) {
        Task task = new Task();
        task.setCode(code);
        task.setStatus(status);
        Task tasks = taskDao.get(task);
        if (tasks!=null){
            tasks.setStatus(1);
            taskDao.update(tasks);
        }

    }

    @Override
    public void getpei(String code, Integer status) {
        Task task = new Task();
        task.setCode(code);
        task.setStatus(status);
        Task tasks = taskDao.get(task);
        if (tasks!=null){
            tasks.setStatus(2);
            taskDao.update(tasks);
        }
    }

    @Override
    public void getda(String code,Integer status) {
        Task task = new Task();
        task.setCode(code);
        task.setStatus(status);
        Task tasks = taskDao.get(task);
        if (tasks!=null){
            tasks.setStatus(3);
            taskDao.update(tasks);
        }
    }
}
