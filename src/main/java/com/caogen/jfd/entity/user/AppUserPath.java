package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserPath implements Serializable {

	private static final long serialVersionUID = 1829157775148787101L;
	private Integer id;
	private Integer user_id;
	private String name;
	private String description;
//	@SerializedName("origin_str")
	private String origin;
//	@SerializedName("origin")
	private AppUserSite origin_obj;
//	@SerializedName("destination_str")
	private String destination;
//	@SerializedName("destination")
	private List<AppUserSite> destination_obj;

	public AppUserPath() {
		super();
	}

	public AppUserPath(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "AppUserPath [id=" + id + ", user_id=" + user_id + ", name=" + name + ", description=" + description
				+ ", origin=" + origin + ", origin_obj=" + origin_obj + ", destination=" + destination
				+ ", destination_obj=" + destination_obj + "]";
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

	public AppUserSite getOrigin_obj() {
		return origin_obj;
	}

	public void setOrigin_obj(AppUserSite origin_obj) {
		this.origin_obj = origin_obj;
	}

	public List<AppUserSite> getDestination_obj() {
		return destination_obj;
	}

	public void setDestination_obj(List<AppUserSite> destination_obj) {
		this.destination_obj = destination_obj;
	}

}
