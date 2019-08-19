package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Systemm implements Serializable {

    private static final long serialVersionUID = -3975707114992384337L;
    private Integer id; //id
    private String title;//标题
    private String content;//内容
    private LocalDateTime create_date;//创建时间
    private String CreateDate;

    @Override
    public String toString() {
        return "Systemm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_date=" + create_date +
                '}';
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
}