package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Vehicle extends Model implements Serializable {
    private static final long serialVersionUID = -3977307114992384041L;
    private Integer id; //id
    private Integer model_id;//车型id
    private Type type;//类型：自有、挂靠
    private  String number;//车牌号
    private LocalDateTime create_date;//开始时间
    private String photo_url; //车辆照片URL
    private String license_url;//行驶证照片URL
    private Boolean is_allot;//是否分配司机
    private Integer driver_id;//司机id

    public enum  Type{
        owned,affiliated
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", type=" + type +
                ", number='" + number + '\'' +
                ", create_date=" + create_date +
                ", photo_url='" + photo_url + '\'' +
                ", license_url='" + license_url + '\'' +
                ", is_allot=" + is_allot +
                ", driver_id=" + driver_id +
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

    public Integer getModel_id() {
        return model_id;
    }

    public void setModel_id(Integer model_id) {
        this.model_id = model_id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }

    public Boolean getIs_allot() {
        return is_allot;
    }

    public void setIs_allot(Boolean is_allot) {
        this.is_allot = is_allot;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }
}
