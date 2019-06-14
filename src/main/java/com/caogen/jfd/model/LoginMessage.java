package com.caogen.jfd.model;

import java.io.Serializable;

import com.caogen.jfd.entity.AppThird;
import com.caogen.jfd.entity.AppUser;

/**
 * 
 * @author Spuiln
 *
 */
public class LoginMessage implements Serializable {

	private static final long serialVersionUID = -3781059565730363030L;
	private AppUser.Identity identity;
	private Mode mode;
	private String username;
	private String password;
	private String sms;
	private AppThird.Thirdparty thirdparty;
	private String identifier;
	private String portrait_url;
	private String referrer;
	private String token;

	public enum Mode {
		password, sms, third
	}

	@Override
	public String toString() {
		return "LoginMessage [identity=" + identity + ", mode=" + mode + ", username=" + username + ", password="
				+ password + ", sms=" + sms + ", thirdparty=" + thirdparty + ", identifier=" + identifier
				+ ", portrait_url=" + portrait_url + ", referrer=" + referrer + ", token=" + token + "]";
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

	public String getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public AppThird.Thirdparty getThirdparty() {
		return thirdparty;
	}

	public void setThirdparty(AppThird.Thirdparty thirdparty) {
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

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
