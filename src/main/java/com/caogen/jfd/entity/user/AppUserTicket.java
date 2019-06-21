package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserTicket implements Serializable {

	private static final long serialVersionUID = -1216643014979706211L;
	private Integer id;
	private String phone;
	private String ticket;
	private Boolean available;
	private Reason reason;

	public enum Reason {
		past, use
	}

	public AppUserTicket() {
		super();
	}

	public AppUserTicket(Integer id) {
		super();
		this.id = id;
	}

	public AppUserTicket(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppUserTicket [id=" + id + ", phone=" + phone + ", ticket=" + ticket + ", available=" + available
				+ ", reason=" + reason + "]";
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

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
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

}
