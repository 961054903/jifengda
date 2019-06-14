package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalTime;

public class IssueFaq implements Serializable {
    private static final long serialVersionUID = -3975707114992384047L;
    private Integer id; //id
    private  String title;//标题
    private  String context;//内容
    private  String photo_url;//图片
    private LocalTime create_date;//创建时间

    @Override
    public String toString() {
        return "IssueFaq{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", create_date=" + create_date +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public LocalTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalTime create_date) {
        this.create_date = create_date;
    }
}
