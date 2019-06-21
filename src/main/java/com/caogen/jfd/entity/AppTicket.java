package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Spuiln
 *
 */
public class AppTicket implements Serializable {

	private static final long serialVersionUID = 3323431490446042899L;
	private String title;
	private String description;
	private Double money;
	private Type type;
	private Double sill;
	private LocalDateTime start_date;
	private LocalDateTime end_data;
	private Double duration;

	public enum Type {
		common, condition
	}

	@Override
	public String toString() {
		return "AppTicket [title=" + title + ", description=" + description + ", money=" + money + ", type=" + type
				+ ", sill=" + sill + ", start_date=" + start_date + ", end_data=" + end_data + ", duration=" + duration
				+ "]";
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

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Double getSill() {
		return sill;
	}

	public void setSill(Double sill) {
		this.sill = sill;
	}

	public LocalDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDateTime start_date) {
		this.start_date = start_date;
	}

	public LocalDateTime getEnd_data() {
		return end_data;
	}

	public void setEnd_data(LocalDateTime end_data) {
		this.end_data = end_data;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

}
