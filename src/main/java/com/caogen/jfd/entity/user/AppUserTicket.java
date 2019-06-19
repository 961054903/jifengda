package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserTicket implements Serializable {

	private static final long serialVersionUID = -5915627962332462479L;
	private Integer id;
	private Integer user_ticket_id;
	private Integer app_ticket_id;
	private Boolean available;
	private Reason reason;
	private String phone;

	public enum Reason {
		past, use
	}

	public AppUserTicket(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AppUserTicket [id=" + id + ", user_ticket_id=" + user_ticket_id + ", app_ticket_id=" + app_ticket_id
				+ ", available=" + available + ", reason=" + reason + ", phone=" + phone + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_ticket_id() {
		return user_ticket_id;
	}

	public void setUser_ticket_id(Integer user_ticket_id) {
		this.user_ticket_id = user_ticket_id;
	}

	public Integer getApp_ticket_id() {
		return app_ticket_id;
	}

	public void setApp_ticket_id(Integer app_ticket_id) {
		this.app_ticket_id = app_ticket_id;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Reason getReason() {
		return reason;
	}

	public void setReason(Reason reason) {
		this.reason = reason;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
