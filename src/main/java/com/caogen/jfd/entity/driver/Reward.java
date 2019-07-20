package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reward implements Serializable {


    private static final long serialVersionUID = -3975707111992384047L;
    private Integer id; //id
    private String activityname;//奖励内容
    private LocalDateTime  create_date; //创建时间
    private Double money;//奖励金额
    private Integer driver_id;
    private String CreateDate;

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String createDate) {
        CreateDate = createDate;
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

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", activityname='" + activityname + '\'' +
                ", create_date=" + create_date +
                ", money=" + money +
                ", driver_id='" + driver_id + '\'' +
                '}';
    }
}
