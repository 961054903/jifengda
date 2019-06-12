package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUser implements Serializable {

	private static final long serialVersionUID = -5753387388562949447L;
	private Integer id;
	private Identity identity;
	private String username;
	private String password;
	private String salt;
	private Status status;
	private LocalDate create_date;
	private String key;
	private String iv;
	private String token;

	public enum Identity {
		user, driver
	}

	public enum Status {
		normal, locked
	}

	@Override
	public String toString() {
		return "AppUser [id=" + id + ", identity=" + identity + ", username=" + username + ", password=" + password
				+ ", salt=" + salt + ", status=" + status + ", create_date=" + create_date + ", key=" + key + ", iv="
				+ iv + ", token=" + token + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDate create_date) {
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
