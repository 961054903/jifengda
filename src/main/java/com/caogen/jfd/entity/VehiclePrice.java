package com.caogen.jfd.entity;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class VehiclePrice implements Serializable {

	private static final long serialVersionUID = -5529440447397000548L;
	private Integer id;
	private Integer model_id;
	private Double start_space;
	private Double end_space;
	private Double price;

	public VehiclePrice() {
		super();
	}

	public VehiclePrice(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "VehiclePrice [id=" + id + ", model_id=" + model_id + ", start_space=" + start_space + ", end_space="
				+ end_space + ", price=" + price + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public Double getStart_space() {
		return start_space;
	}

	public void setStart_space(Double start_space) {
		this.start_space = start_space;
	}

	public Double getEnd_space() {
		return end_space;
	}

	public void setEnd_space(Double end_space) {
		this.end_space = end_space;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
