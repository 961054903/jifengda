package com.caogen.jfd.entity;

import java.io.Serializable;

public class Task implements Serializable {
    private static final long serialVersionUID = -3933707114992384047L;
    private Integer id; //id
    private String code;//订单号
    private String serial;//任务编号
    private String destination;//收货地址
    private Integer status;//订单状态 ：1.已到达 2.已取货 3.配送完成

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", serial='" + serial + '\'' +
                ", destination='" + destination + '\'' +
                ", status=" + status +
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
