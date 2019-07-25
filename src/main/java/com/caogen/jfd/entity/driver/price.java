package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalTime;


public class price implements Serializable {
    private static final long serialVersionUID = -3975707111792384047L;
    private Integer id; //id
    private Double is_work;//是否营业
    private LocalTime work_start;//营业时间
    private LocalTime work_end;//下班时间
    private  String city;//城市
    private Double scope;//智能调度范围（km）
    private Double duration;//智能调度时长（s）


    @Override
    public String toString() {
        return "price{" +
                "id=" + id +
                ", is_work=" + is_work +
                ", work_start=" + work_start +
                ", work_end=" + work_end +
                ", city='" + city + '\'' +
                ", scope=" + scope +
                ", duration=" + duration +
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

    public Double getIs_work() {
        return is_work;
    }

    public void setIs_work(Double is_work) {
        this.is_work = is_work;
    }

    public LocalTime getWork_start() {
        return work_start;
    }

    public void setWork_start(LocalTime work_start) {
        this.work_start = work_start;
    }

    public LocalTime getWork_end() {
        return work_end;
    }

    public void setWork_end(LocalTime work_end) {
        this.work_end = work_end;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getScope() {
        return scope;
    }

    public void setScope(Double scope) {
        this.scope = scope;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
