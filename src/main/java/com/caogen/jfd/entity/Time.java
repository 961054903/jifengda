package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Time implements Serializable {


    private static final long serialVersionUID = -3933707114992384047L;
    private Integer id; //id
    private String phone;//手机号
    private LocalDateTime time;//时间
    private  Double one_day;//一天时间
    private String tim;//时间


    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", time=" + time +
                ", one_day=" + one_day +
                ", tim='" + tim + '\'' +
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

    public Double getOne_day() {
        return one_day;
    }

    public void setOne_day(Double one_day) {
        this.one_day = one_day;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }
}
