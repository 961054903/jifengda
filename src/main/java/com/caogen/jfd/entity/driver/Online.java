package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Online implements Serializable {
    private static final long serialVersionUID = -3975707110062364047L;
    private Integer id; //id
    private Operation operation; //操作：上线/下线
    private LocalDateTime create_date;
    private Integer driver_id;


    public enum  Operation{
        online,offline
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Override
    public String toString() {
        return "Online{" +
                "id=" + id +
                ", operation=" + operation +
                ", create_date=" + create_date +
                ", driver_id=" + driver_id +
                '}';
    }
}
