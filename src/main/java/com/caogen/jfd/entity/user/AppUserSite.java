package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserSite implements Serializable {

	private static final long serialVersionUID = 2455774296222366921L;
	private Integer id;
	private Integer user_id;
	private String name;
	private String description;
	private Double longitude;
	private Double latitude;
	private String contacts_name;
	private String contacts_phone;

	public AppUserSite() {
		super();
	}

	public AppUserSite(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AppUserSite [id=" + id + ", user_id=" + user_id + ", name=" + name + ", description=" + description
				+ ", longitude=" + longitude + ", latitude=" + latitude + ", contacts_name=" + contacts_name
				+ ", contacts_phone=" + contacts_phone + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
