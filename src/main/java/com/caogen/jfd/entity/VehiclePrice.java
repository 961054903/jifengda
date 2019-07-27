package com.caogen.jfd.entity;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * 
 * @author Spuiln
 *
 */
public class VehiclePrice implements Serializable {

	private static final long serialVersionUID = -5529440447397000548L;
	private Integer id;
	private Integer model_id;
	private Double night_cost;
	private Boolean is_night;
	private LocalTime night_start;
	private LocalTime night_end;
	private Double jam_cost;
	private Boolean is_jam;
	private LocalTime jam_start;
	private LocalTime jam_end;
	private Double empty_cost;
	private String single;
	private String multitude;
	private Double bonus;
	private String city;

	public VehiclePrice() {
		super();
	}

	public VehiclePrice(Integer id) {
		super();
		this.id = id;
	}

	public class Price {
		private Double start_space;
		private Double end_space;
		private Double price;

		@Override
		public String toString() {
			return "Price [start_space=" + start_space + ", end_space=" + end_space + ", price=" + price + "]";
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

	@Override
	public String toString() {
		return "VehiclePrice [id=" + id + ", model_id=" + model_id + ", night_cost=" + night_cost + ", is_night="
				+ is_night + ", night_start=" + night_start + ", night_end=" + night_end + ", jam_cost=" + jam_cost
				+ ", is_jam=" + is_jam + ", jam_start=" + jam_start + ", jam_end=" + jam_end + ", empty_cost="
				+ empty_cost + ", single=" + single + ", multitude=" + multitude + ", bonus=" + bonus + ", city=" + city
				+ "]";
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

	public Double getNight_cost() {
		return night_cost;
	}

	public void setNight_cost(Double night_cost) {
		this.night_cost = night_cost;
	}

	public Boolean getIs_night() {
		return is_night;
	}

	public void setIs_night(Boolean is_night) {
		this.is_night = is_night;
	}

	public Double getJam_cost() {
		return jam_cost;
	}

	public void setJam_cost(Double jam_cost) {
		this.jam_cost = jam_cost;
	}

	public Boolean getIs_jam() {
		return is_jam;
	}

	public void setIs_jam(Boolean is_jam) {
		this.is_jam = is_jam;
	}

	public Double getEmpty_cost() {
		return empty_cost;
	}

	public void setEmpty_cost(Double empty_cost) {
		this.empty_cost = empty_cost;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	public String getMultitude() {
		return multitude;
	}

	public void setMultitude(String multitude) {
		this.multitude = multitude;
	}

	public LocalTime getNight_start() {
		return night_start;
	}

	public void setNight_start(LocalTime night_start) {
		this.night_start = night_start;
	}

	public LocalTime getNight_end() {
		return night_end;
	}

	public void setNight_end(LocalTime night_end) {
		this.night_end = night_end;
	}

	public LocalTime getJam_start() {
		return jam_start;
	}

	public void setJam_start(LocalTime jam_start) {
		this.jam_start = jam_start;
	}

	public LocalTime getJam_end() {
		return jam_end;
	}

	public void setJam_end(LocalTime jam_end) {
		this.jam_end = jam_end;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

}
