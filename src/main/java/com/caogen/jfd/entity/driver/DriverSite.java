package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DriverSite implements Serializable {
    private static final long serialVersionUID = -1975707114992664047L;
    private Integer id; //id
    private String phone;//手机号
    private LocalDateTime create_date;//创建时间
    private Double longitude;//经度
    private Double latitude;//维度

    @Override
    public String toString() {
        return "DriverSite{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", create_date=" + create_date +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
