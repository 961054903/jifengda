package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * sys_config 实体类
 * 
 * @author Spuiln
 *
 */
public class SysConfig implements Serializable {

	private static final long serialVersionUID = -3975707114992384047L;
	private Integer id;
	private String item;
	private String item_key;
	private String item_value;
	private String description;
	@DateTimeFormat(pattern = "HHmmss")
	@JsonFormat(pattern = "HHmmss", timezone = "GMT+8")
	private LocalTime start_time;
	@DateTimeFormat(pattern = "HHmmss")
	@JsonFormat(pattern = "HHmmss", timezone = "GMT+8")
	private LocalTime end_time;
	private Boolean flag;

	public SysConfig() {
		super();
	}

	public SysConfig(Integer id) {
		super();
		this.id = id;
	}

	public SysConfig(String item_key) {
		super();
		this.item_key = item_key;
	}

	@Override
	public String toString() {
		return "SysConfig [id=" + id + ", item=" + item + ", item_key=" + item_key + ", item_value=" + item_value
				+ ", description=" + description + ", start_time=" + start_time + ", end_time=" + end_time + ", flag="
				+ flag + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getItem_key() {
		return item_key;
	}

	public void setItem_key(String item_key) {
		this.item_key = item_key;
	}

	public String getItem_value() {
		return item_value;
	}

	public void setItem_value(String item_value) {
		this.item_value = item_value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalTime getStart_time() {
		return start_time;
	}

	public void setStart_time(LocalTime start_time) {
		this.start_time = start_time;
	}

	public LocalTime getEnd_time() {
		return end_time;
	}

	public void setEnd_time(LocalTime end_time) {
		this.end_time = end_time;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}
