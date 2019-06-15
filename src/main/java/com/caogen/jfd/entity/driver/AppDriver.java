package com.caogen.jfd.entity.driver;
import java.io.Serializable;
import java.time.LocalDateTime;


public class AppDriver implements Serializable {
    private static final long serialVersionUID = -5753387388562949447L;
    private Integer id;   //id
    private String drivename;  //司机姓名
    private String password;   //密码
    private Status status;  // 状态
    private LocalDateTime create_date;   //创建时间
    private String key;//3DES算法所需密钥
    private String iv; // 3DES算法所需向量
    private String token;



    public enum Status {
        normal, locked
    }

    @Override
    public String toString() {
        return "AppDriver{" +
                "id=" + id +
                ", drivename='" + drivename + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", create_date=" + create_date +
                ", key='" + key + '\'' +
                ", iv='" + iv + '\'' +
                ", token='" + token + '\'' +
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

    public String getDrivename() {
        return drivename;
    }

    public void setDrivename(String drivename) {
        this.drivename = drivename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
