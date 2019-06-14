package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class FeedBack implements Serializable {
    private static final long serialVersionUID = -3975707114992384047L;
    private Integer id; //id
    private Integer user_id; //用户id
    private String type;//类型 问题，建议
    private String title;//标题
    private String content;//内容
    private String photo_url; //图片
    private Boolean is_check;// 是否查看
    private LocalDateTime create_date;//创建时间

    public Boolean getIs_check() {
        return is_check;
    }

    public void setIs_check(Boolean is_check) {
        this.is_check = is_check;

    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", is_check='" + is_check + '\'' +
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

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }
}



