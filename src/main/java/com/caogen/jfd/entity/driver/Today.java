package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Today implements Serializable {


    private static final long serialVersionUID = -3975707114992384047L;
    private Integer id; //id
    private String phone;//手机号
    private LocalDateTime time;//累计时间


    @Override
    public String toString() {
        return "Today{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", time=" + time +
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
