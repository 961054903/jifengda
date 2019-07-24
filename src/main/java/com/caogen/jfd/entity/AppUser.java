package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUser implements Serializable {

	private static final long serialVersionUID = -5753387388562949447L;
	private Integer id;
	private String phone;
	private String password;
	private String salt;
	private State state;
	private LocalDateTime create_date;
	private String des_key;
	private String des_iv;
	private String token;
	private String referrer;
	private Double referrer_award;

	public enum State {
		normal, locked
	}

	public AppUser() {
		super();
	}

	public AppUser(Integer id) {
		super();
		this.id = id;
	}

	public AppUser(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", phone=" + phone + ", password=" + password + ", salt=" + salt + ", state="
				+ state + ", create_date=" + create_date + ", des_key=" + des_key + ", des_iv=" + des_iv + ", token="
				+ token + ", referrer=" + referrer + ", referrer_award=" + referrer_award + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public Double getReferrer_award() {
		return referrer_award;
	}

	public void setReferrer_award(Double referrer_award) {
		this.referrer_award = referrer_award;
	}

}
