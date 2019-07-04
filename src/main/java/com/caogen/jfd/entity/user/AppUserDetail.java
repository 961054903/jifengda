package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserDetail implements Serializable {

	private static final long serialVersionUID = 8503617011345576928L;
	private Integer id;
	private Integer user_id;
	private String title;
	private String description;
	private Type type;
	private Double money;
	private LocalDateTime create_date;
	private String createDate;

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

	@Override
	public String toString() {
		return "AppUserDetail [id=" + id + ", user_id=" + user_id + ", title=" + title + ", description=" + description
				+ ", type=" + type + ", money=" + money + ", create_date=" + create_date + ", createDate=" + createDate
				+ "]";
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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
