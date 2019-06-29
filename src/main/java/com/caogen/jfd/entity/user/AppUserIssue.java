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
public class AppUserIssue implements Serializable {

	private static final long serialVersionUID = 7131692433602001263L;
	private Integer id;
	private String title;
	private String content;
	private String photo_url;
	@DateTimeFormat(pattern = "yyyyMMddHHmmss")
	@JsonFormat(pattern = "yyyyMMddHHmmss", timezone = "GMT+8")
	private LocalDateTime create_date;
	private String name;
	private String phone;
	private Boolean is_check;
	private Type type;

	public enum Type {
		problem, suggest, faq
	}

	public AppUserIssue() {
		super();
	}

	public AppUserIssue(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AppUserIssue [id=" + id + ", title=" + title + ", content=" + content + ", photo_url=" + photo_url
				+ ", create_date=" + create_date + ", name=" + name + ", phone=" + phone + ", is_check=" + is_check
				+ ", type=" + type + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto_url() {
		return photo_url;
	}

	public void setPhoto_url(String photo_url) {
		this.photo_url = photo_url;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIs_check() {
		return is_check;
	}

	public void setIs_check(Boolean is_check) {
		this.is_check = is_check;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
