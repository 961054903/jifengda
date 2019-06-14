package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * APP用户信息entity
 * 
 * @author Spuiln
 *
 */
public class AppUserInfo implements Serializable {

	private static final long serialVersionUID = 8293865348126760421L;
	private Integer id;
	private Integer app_user_id;
	private String phone;
	private String photo_url;
	private String nickname;
	private Integer level;
	private Gender gender;
	private LocalDateTime birthday;
	private String occupation;
	private Boolean is_real;
	private String name;
	private String identity_number;
	private String identity_front_url;
	private String identity_back_url;
	private Double balance;

	public enum Gender {
		unknown, female, male
	}

	@Override
	public String toString() {
		return "AppUserInfo [id=" + id + ", app_user_id=" + app_user_id + ", phone=" + phone + ", photo_url="
				+ photo_url + ", nickname=" + nickname + ", level=" + level + ", gender=" + gender + ", birthday="
				+ birthday + ", occupation=" + occupation + ", is_real=" + is_real + ", name=" + name
				+ ", identity_number=" + identity_number + ", identity_front_url=" + identity_front_url
				+ ", identity_back_url=" + identity_back_url + ", balance=" + balance + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getApp_user_id() {
		return app_user_id;
	}

	public void setApp_user_id(Integer app_user_id) {
		this.app_user_id = app_user_id;
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
