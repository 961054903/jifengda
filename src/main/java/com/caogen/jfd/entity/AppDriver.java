package com.caogen.jfd.entity;
import java.io.Serializable;
import java.time.LocalDateTime;


public class AppDriver implements Serializable {
    private static final long serialVersionUID = -4753387388562949447L;
    private Integer id;   //id
    private String driverphone;  //司机姓名
    private String password;   //密码
    private Status status;  // 状态
    private String salt;//盐
    private LocalDateTime create_date;   //创建时间
    private String des_key;//3DES算法所需密钥
    private String des_iv; // 3DES算法所需向量
    private String token;


    public AppDriver() {
        super();
    }


    public AppDriver(String driverphone) {
        super();
        this.driverphone = driverphone;
    }

    public AppDriver(String driverphone, String password) {
        super();
        this.driverphone = driverphone;
        this.password = password;
    }

    public enum Status {
        normal,locked
    }

    @Override
    public String toString() {
        return "AppDriver{" +
                "id=" + id +
                ", driverphone='" + driverphone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", salt='" + salt + '\'' +
                ", create_date=" + create_date +
                ", des_key='" + des_key + '\'' +
                ", des_iv='" + des_iv + '\'' +
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

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Enum getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public String getDes_key() {
        return des_key;
    }

    public void setDes_key(String des_key) {
        this.des_key = des_key;
    }

    public String getDes_iv() {
        return des_iv;
    }

    public void setDes_iv(String des_iv) {
        this.des_iv = des_iv;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}