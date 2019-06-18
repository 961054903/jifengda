package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserThird implements Serializable {

	private static final long serialVersionUID = 840412543253621587L;
	private Integer id;
	private String phone;
	private Thirdparty thirdparty;
	private String identifier;
	private String credential;
	private String portrait_url;

	public enum Thirdparty {
		qq, weixin, weibo
	}

	public AppUserThird() {
		super();
	}

	public AppUserThird(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AppUserThird [id=" + id + ", phone=" + phone + ", thirdparty=" + thirdparty + ", identifier="
				+ identifier + ", credential=" + credential + ", portrait_url=" + portrait_url + "]";
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

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getPortrait_url() {
		return portrait_url;
	}

	public void setPortrait_url(String portrait_url) {
		this.portrait_url = portrait_url;
	}

}
