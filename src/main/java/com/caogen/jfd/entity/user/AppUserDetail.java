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
public class AppUserDetail implements Serializable {

	private static final long serialVersionUID = 8503617011345576928L;
	private Integer id;
	private String phone;
	private String title;
	private String description;
	private Type type;
	private Double money;
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	private LocalDateTime create_date;

	public enum Type {
		incoming, outgoing
	}

	public AppUserDetail() {
		super();
	}

	public AppUserDetail(Integer id) {
		super();
		this.id = id;
	}

	public AppUserDetail(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppUserDetail [id=" + id + ", phone=" + phone + ", title=" + title + ", description=" + description
				+ ", type=" + type + ", money=" + money + ", create_date=" + create_date + "]";
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

}
