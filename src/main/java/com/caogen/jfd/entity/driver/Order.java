package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {

    private static final long serialVersionUID = -3975707114992384046L;
    private Integer id; //id
    private LocalDateTime create_date;//创建时间
    private Integer driver_id;//司机id
    private Integer order_total;//订单数


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", create_date=" + create_date +
                ", driver_id=" + driver_id +
                ", order_total=" + order_total +
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

    public Integer getOrder_total() {
        return order_total;
    }

    public void setOrder_total(Integer order_total) {
        this.order_total = order_total;
    }
}
