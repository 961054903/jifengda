package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    private static final long serialVersionUID = -3977307114992384047L;
    private Integer id; //id
    private String phone;//手机号
    private String photo_url;//头像照片URL
    private String nickname;//昵称
    private Integer level;//等级
    private Gender gender;//性别：未知、男、女
    private LocalDateTime birthday;//生日
    private String occupation;//行业
    private Boolean is_real;//是否实名认证
    private String name;//姓名
    private String identity_number;//身份证号
    private String identity_front_url;//身份证正面照片URL
    private String identity_back_url;//身份证背面照片URL
    private Double balance;//余额


    public enum Gender{
        unknown,female,male
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", nickname='" + nickname + '\'' +
                ", level=" + level +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", occupation='" + occupation + '\'' +
                ", is_real=" + is_real +
                ", name='" + name + '\'' +
                ", identity_number='" + identity_number + '\'' +
                ", identity_front_url='" + identity_front_url + '\'' +
                ", identity_back_url='" + identity_back_url + '\'' +
                ", balance=" + balance +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Boolean getIs_real() {
        return is_real;
    }

    public void setIs_real(Boolean is_real) {
        this.is_real = is_real;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String identity_number) {
        this.identity_number = identity_number;
    }

    public String getIdentity_front_url() {
        return identity_front_url;
    }

    public void setIdentity_front_url(String identity_front_url) {
        this.identity_front_url = identity_front_url;
    }

    public String getIdentity_back_url() {
        return identity_back_url;
    }

    public void setIdentity_back_url(String identity_back_url) {
        this.identity_back_url = identity_back_url;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}