package com.caogen.jfd.entity.user;
/**
 * 
 * @author Spuiln
 *
 */

import java.io.Serializable;
import java.util.List;

public class AppUserPath implements Serializable {

	private static final long serialVersionUID = 1829157775148787101L;
	private Integer id;
	private String phone;
	private String name;
	private String description;
	private AppUserSite origin;
	private List<AppUserSite> destination;

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

	public AppUserSite getOrigin() {
		return origin;
	}

	public void setOrigin(AppUserSite origin) {
		this.origin = origin;
	}

	public List<AppUserSite> getDestination() {
		return destination;
	}

	public void setDestination(List<AppUserSite> destination) {
		this.destination = destination;
	}

}
