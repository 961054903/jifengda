package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Royalty implements Serializable {

    private static final long serialVersionUID = -3975707114992384337L;
    private Integer id; //id
    private  String phone;//手机号
    private LocalDateTime create_date;//创建时间
    private  String code; //订单号
    private  Double bonus;//提成

    @Override
    public String toString() {
        return "Royalty{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", create_date=" + create_date +
                ", code='" + code + '\'' +
                ", bonus=" + bonus +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
}
