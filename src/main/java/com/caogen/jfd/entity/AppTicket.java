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
	private String startDate;
	private LocalDateTime end_date;
	private String endDate;
	private Double duration;

	public enum Type {
		common, condition
	}

	@Override
	public String toString() {
		return "AppTicket [title=" + title + ", description=" + description + ", money=" + money + ", type=" + type
				+ ", sill=" + sill + ", start_date=" + start_date + ", startDate=" + startDate + ", end_date="
				+ end_date + ", endDate=" + endDate + ", duration=" + duration + "]";
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDateTime end_date) {
		this.end_date = end_date;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

}
