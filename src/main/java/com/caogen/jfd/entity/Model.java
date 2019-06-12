package com.caogen.jfd.entity;

import java.io.Serializable;

public class Model implements Serializable {
    private static final long serialVersionUID = -3975707114992384047L;
    private Integer id; //id
    private String brand; // 所属品牌
    private String model;//车型
    private Double length; //长
    private Double width; //宽
    private Double height;//高
    private Double volume; //货物体积
    private Double capacity; //载重
    private Double empty_cost;//空时费
    private Double night_cost;//夜间服务费
    private Double starting_cost;//起步价
    private Double starting_scope;//起步距离

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", volume=" + volume +
                ", capacity=" + capacity +
                ", empty_cost=" + empty_cost +
                ", night_cost=" + night_cost +
                ", starting_cost=" + starting_cost +
                ", starting_scope=" + starting_scope +
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getcapacity() {
        return capacity;
    }

    public void setcapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getEmpty_cost() {
        return empty_cost;
    }

    public void setEmpty_cost(Double empty_cost) {
        this.empty_cost = empty_cost;
    }

    public Double getNight_cost() {
        return night_cost;
    }

    public void setNight_cost(Double night_cost) {
        this.night_cost = night_cost;
    }

    public Double getStarting_cost() {
        return starting_cost;
    }

    public void setStarting_cost(Double starting_cost) {
        this.starting_cost = starting_cost;
    }

    public Double getStarting_scope() {
        return starting_scope;
    }

    public void setStarting_scope(Double starting_scope) {
        this.starting_scope = starting_scope;
    }
}
