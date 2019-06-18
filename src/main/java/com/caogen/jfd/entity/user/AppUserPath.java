package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserPath implements Serializable {

	private static final long serialVersionUID = 1829157775148787101L;
	private Integer id;
	private String phone;
	private String name;
	private String description;
	private String origin;
	private String destination;

	@Override
	public String toString() {
		return "AppUserPath [id=" + id + ", phone=" + phone + ", name=" + name + ", description=" + description
				+ ", origin=" + origin + ", destination=" + destination + "]";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

}
