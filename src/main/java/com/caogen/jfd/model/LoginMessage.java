package com.caogen.jfd.model;

import java.io.Serializable;

import com.caogen.jfd.entity.AppUser;

public class LoginMessage extends Message implements Serializable {

	private static final long serialVersionUID = -3781059565730363030L;
	private AppUser.Identity identity;
	private Mode mode;
	private String username;
	private String password;
	private Thirdparty thirdparty;
	private String identifier;
	private String portrait_url;
	private String token;

	public enum Mode {
		password, code, third
	}

	public enum Thirdparty {
		qq, weixin, weibo
	}

	@Override
	public String toString() {
		return "LoginMessage [identity=" + identity + ", mode=" + mode + ", username=" + username + ", password="
				+ password + ", thirdparty=" + thirdparty + ", identifier=" + identifier + ", portrait_url="
				+ portrait_url + ", token=" + token + "]";
	}

	public AppUser.Identity getIdentity() {
		return identity;
	}

	public void setIdentity(AppUser.Identity identity) {
		this.identity = identity;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
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

	public Thirdparty getThirdparty() {
		return thirdparty;
	}

	public void setThirdparty(Thirdparty thirdparty) {
		this.thirdparty = thirdparty;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPortrait_url() {
		return portrait_url;
	}

	public void setPortrait_url(String portrait_url) {
		this.portrait_url = portrait_url;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
