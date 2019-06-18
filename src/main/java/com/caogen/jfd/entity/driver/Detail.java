package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Detail implements Serializable {
    private static final long serialVersionUID = -1975707114992384147L;
    private Integer id; //id
    private String phone;//手机号
    private LocalDateTime create_date;//创建时间
    private  Operation operation;//操作：上线/下线


    public enum Operation {
        online,offline
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", create_date=" + create_date +
                ", operation=" + operation +
                '}';
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
