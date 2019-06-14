package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Spuiln
 *
 */
public class AppSms implements Serializable {

	private static final long serialVersionUID = -6947492986174465214L;
	private Integer id;
	private String phone;
	private String code;
	private LocalDateTime create_date;
	private Boolean available;

	@Override
	public String toString() {
		return "AppSms [id=" + id + ", phone=" + phone + ", code=" + code + ", create_date=" + create_date
				+ ", available=" + available + "]";
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

}
