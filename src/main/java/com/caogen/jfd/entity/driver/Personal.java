package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Personal implements Serializable {

    private static final long serialVersionUID = -3975707114992384038L;
    private Integer id; //id
    private Integer user_id;//司机id
    private String phone;//手机号
    private String photo_url;//头像照片URL
    private String name; //姓名
    private String identity_number;//身份证号码
    private Integer grade;//评分
    private String gender; //性别 unknown,female,male
    private LocalDateTime birthday;//生日
    private String licence_url;//驾驶证照片
    private String identity_front_url;//身份证正面
    private String identity_back_url;//身份证背面
    private String identity_take_url;//身份证手持照片
    private String contacts_name;//紧急联系人姓名
    private String contacts_phone;//紧急联系人手机号
    private String contacts_gender;//紧急联系人性别
    private String contacts_relation;//紧急联系人关系
    private Boolean is_online;//是否在线
    private Double longitude;//经度
    private Double latitude;//维度
    private  String Age;
    private jinji  urgent;
    private Model model;
    private Double oreder;
    private Double money;

    public Double getOreder() {
        return oreder;
    }

    public void setOreder(Double oreder) {
        this.oreder = oreder;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", phone='" + phone + '\'' +
                ", photo_url='" + photo_url + '\'' +
                ", name='" + name + '\'' +
                ", identity_number='" + identity_number + '\'' +
                ", grade=" + grade +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", licence_url='" + licence_url + '\'' +
                ", identity_front_url='" + identity_front_url + '\'' +
                ", identity_back_url='" + identity_back_url + '\'' +
                ", identity_take_url='" + identity_take_url + '\'' +
                ", contacts_name='" + contacts_name + '\'' +
                ", contacts_phone='" + contacts_phone + '\'' +
                ", contacts_gender='" + contacts_gender + '\'' +
                ", contacts_relation='" + contacts_relation + '\'' +
                ", is_online=" + is_online +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public jinji getUrgent() {
        return urgent;
    }

    public void setUrgent(jinji urgent) {
        this.urgent = urgent;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getLicence_url() {
        return licence_url;
    }

    public void setLicence_url(String licence_url) {
        this.licence_url = licence_url;
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

    public String getIdentity_take_url() {
        return identity_take_url;
    }

    public void setIdentity_take_url(String identity_take_url) {
        this.identity_take_url = identity_take_url;
    }

    public String getContacts_name() {
        return contacts_name;
    }

    public void setContacts_name(String contacts_name) {
        this.contacts_name = contacts_name;
    }

    public String getContacts_phone() {
        return contacts_phone;
    }

    public void setContacts_phone(String contacts_phone) {
        this.contacts_phone = contacts_phone;
    }

    public String getContacts_gender() {
        return contacts_gender;
    }

    public void setContacts_gender(String contacts_gender) {
        this.contacts_gender = contacts_gender;
    }

    public String getContacts_relation() {
        return contacts_relation;
    }

    public void setContacts_relation(String contacts_relation) {
        this.contacts_relation = contacts_relation;
    }

    public Boolean getIs_online() {
        return is_online;
    }

    public void setIs_online(Boolean is_online) {
        this.is_online = is_online;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


}