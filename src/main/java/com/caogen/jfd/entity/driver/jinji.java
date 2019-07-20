package com.caogen.jfd.entity.driver;

import java.io.Serializable;

public class jinji implements Serializable {
    private static final long serialVersionUID = -975707154992384347L;
    private Integer id; //id
    private String contacts_name;//紧急联系人姓名
    private String contacts_phone;//紧急联系人手机号
    private String contacts_gender;//紧急联系人性别
    private String contacts_relation;//紧急联系人关系

    @Override
    public String toString() {
        return "jinji{" +
                "id=" + id +
                ", contacts_name='" + contacts_name + '\'' +
                ", contacts_phone='" + contacts_phone + '\'' +
                ", contacts_gender='" + contacts_gender + '\'' +
                ", contacts_relation='" + contacts_relation + '\'' +
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
}
