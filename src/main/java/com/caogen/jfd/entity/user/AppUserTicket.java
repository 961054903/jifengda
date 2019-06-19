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
	private Integer ticket_id;
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

	public AppUserTicket(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppUserTicket [id=" + id + ", ticket_id=" + ticket_id + ", available=" + available + ", reason="
				+ reason + ", phone=" + phone + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
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
