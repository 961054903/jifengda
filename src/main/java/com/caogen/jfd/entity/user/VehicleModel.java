package com.caogen.jfd.entity.user;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class VehicleModel implements Serializable {

	private static final long serialVersionUID = -2062872484302744282L;
	private Integer id;
	private String brand;
	private String model;
	private Double length;
	private Double width;
	private Double height;
	private Double volume;
	private Double capacity;
	private Double empty_cost;
	private Double night_cost;
	private Double jam_cost;

	public VehicleModel() {
		super();
	}

	public VehicleModel(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "VehicleModel [id=" + id + ", brand=" + brand + ", model=" + model + ", length=" + length + ", width="
				+ width + ", height=" + height + ", volume=" + volume + ", capacity=" + capacity + ", empty_cost="
				+ empty_cost + ", night_cost=" + night_cost + ", jam_cost=" + jam_cost + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getEmpty_cost() {
		return empty_cost;
	}

	public void setEmpty_cost(Double empty_cost) {
		this.empty_cost = empty_cost;
	}

	public Double getNight_cost() {
		return night_cost;
	}

	public void setNight_cost(Double night_cost) {
		this.night_cost = night_cost;
	}

	public Double getJam_cost() {
		return jam_cost;
	}

	public void setJam_cost(Double jam_cost) {
		this.jam_cost = jam_cost;
	}

}
