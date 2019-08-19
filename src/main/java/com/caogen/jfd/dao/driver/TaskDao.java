package com.caogen.jfd.dao.driver;

import com.caogen.jfd.entity.Task;

public interface TaskDao extends BaseDao<Task> {
    Integer checkMin(Task task);

    Integer checkMax(Task task);

    String getRegistrationID(String code);
}
