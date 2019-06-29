package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserSms implements Serializable {

	private static final long serialVersionUID = -6947492986174465214L;
	private Integer id;
	private String phone;
	private String code;
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	private LocalDateTime create_date;

	public AppUserSms() {
		super();
	}

	public AppUserSms(Integer id) {
		super();
		this.id = id;
	}

	public AppUserSms(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppSms [id=" + id + ", phone=" + phone + ", code=" + code + ", create_date=" + create_date + "]";
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

}
