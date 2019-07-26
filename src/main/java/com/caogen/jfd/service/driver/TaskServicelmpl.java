package com.caogen.jfd.service.driver;

import com.caogen.jfd.dao.driver.TaskDao;
import com.caogen.jfd.dome.JPush;
import com.caogen.jfd.entity.driver.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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
    public void getalready(Integer id, String code ,String serial) {
        Task task = new Task();
        task.setId(id);
        task.setCode(code);
        task.setSerial(serial);
        Task tasks = taskDao.get(task);
         if(tasks.getStatus() == 1){
            tasks.setStatus(2);
            taskDao.update(tasks);
        }else if (tasks.getStatus()== 2) {
            tasks.setStatus(3);
            taskDao.update(tasks);
        }else if (tasks.getStatus()== 3) {
            tasks.setStatus(4);
            taskDao.update(tasks);
        }else if (tasks.getStatus()== 4) {
            tasks.setStatus(5);
            taskDao.update(tasks);
        }else if (tasks.getStatus()== 5) {
            tasks.setStatus(6);
            taskDao.update(tasks);
        }

        Map<String,String> aa = new HashMap<>();
        aa.put("msg","您的订单状态发生改变");
        JPush.jpushAll(aa);
    }

}
