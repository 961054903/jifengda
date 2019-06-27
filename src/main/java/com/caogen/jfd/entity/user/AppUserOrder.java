package com.caogen.jfd.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @author Spuiln
 *
 */
public class AppUserOrder implements Serializable {

	private static final long serialVersionUID = -6671238515019092601L;
	private Integer id;
	private Integer user_id;
	private Integer driver_id;
	private Integer model_id;
	private String code;
	private LocalDateTime create_date;
	private String createDate;
	private Integer status;
	private Type type;
	private Mode mode;
	private LocalDateTime appoint_date;
	private String appointDate;
	private Label label;
	private String origin;
	private String destination;
	private String name;
	private Double night_service_cost;
	private Double traffic_jam_cost;
	private Boolean is_support;
	private Double support_money;
	private Double support_cost;
	private Double order_money;
	private Double ticket_money;
	private Double actually_paid;
	private Double kilometre;
	private Double bonus;
	private Boolean is_evaluate;
	private Integer evaluate_grade;
	private String evaluate_content;

	private String phone;

	public enum Type {
		single, multiple
	}

	public enum Mode {
		common, appoint
	}

	public enum Label {
		none, change, complain, rob, distribution
	}

	public AppUserOrder() {
		super();
	}

	public AppUserOrder(Integer id) {
		super();
		this.id = id;
	}

	public AppUserOrder(String phone) {
		super();
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "AppUserOrder [id=" + id + ", user_id=" + user_id + ", driver_id=" + driver_id + ", model_id=" + model_id
				+ ", code=" + code + ", create_date=" + create_date + ", createDate=" + createDate + ", status="
				+ status + ", type=" + type + ", mode=" + mode + ", appoint_date=" + appoint_date + ", appointDate="
				+ appointDate + ", label=" + label + ", origin=" + origin + ", destination=" + destination + ", name="
				+ name + ", night_service_cost=" + night_service_cost + ", traffic_jam_cost=" + traffic_jam_cost
				+ ", is_support=" + is_support + ", support_money=" + support_money + ", support_cost=" + support_cost
				+ ", order_money=" + order_money + ", ticket_money=" + ticket_money + ", actually_paid=" + actually_paid
				+ ", kilometre=" + kilometre + ", bonus=" + bonus + ", is_evaluate=" + is_evaluate + ", evaluate_grade="
				+ evaluate_grade + ", evaluate_content=" + evaluate_content + ", phone=" + phone + "]";
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

	public Integer getDriver_id() {
		return driver_id;
	}

	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}

	public Integer getModel_id() {
		return model_id;
	}

	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getCreate_date() {
		return create_date;
	}

	public void setCreate_date(LocalDateTime create_date) {
		this.create_date = create_date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public LocalDateTime getAppoint_date() {
		return appoint_date;
	}

	public void setAppoint_date(LocalDateTime appoint_date) {
		this.appoint_date = appoint_date;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getNight_service_cost() {
		return night_service_cost;
	}

	public void setNight_service_cost(Double night_service_cost) {
		this.night_service_cost = night_service_cost;
	}

	public Double getTraffic_jam_cost() {
		return traffic_jam_cost;
	}

	public void setTraffic_jam_cost(Double traffic_jam_cost) {
		this.traffic_jam_cost = traffic_jam_cost;
	}

	public Boolean getIs_support() {
		return is_support;
	}

	public void setIs_support(Boolean is_support) {
		this.is_support = is_support;
	}

	public Double getSupport_money() {
		return support_money;
	}

	public void setSupport_money(Double support_money) {
		this.support_money = support_money;
	}

	public Double getSupport_cost() {
		return support_cost;
	}

	public void setSupport_cost(Double support_cost) {
		this.support_cost = support_cost;
	}

	public Double getOrder_money() {
		return order_money;
	}

	public void setOrder_money(Double order_money) {
		this.order_money = order_money;
	}

	public Double getTicket_money() {
		return ticket_money;
	}

	public void setTicket_money(Double ticket_money) {
		this.ticket_money = ticket_money;
	}

	public Double getActually_paid() {
		return actually_paid;
	}

	public void setActually_paid(Double actually_paid) {
		this.actually_paid = actually_paid;
	}

	public Double getKilometre() {
		return kilometre;
	}

	public void setKilometre(Double kilometre) {
		this.kilometre = kilometre;
	}

	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getIs_evaluate() {
		return is_evaluate;
	}

	public void setIs_evaluate(Boolean is_evaluate) {
		this.is_evaluate = is_evaluate;
	}

	public Integer getEvaluate_grade() {
		return evaluate_grade;
	}

	public void setEvaluate_grade(Integer evaluate_grade) {
		this.evaluate_grade = evaluate_grade;
	}

	public String getEvaluate_content() {
		return evaluate_content;
	}

	public void setEvaluate_content(String evaluate_content) {
		this.evaluate_content = evaluate_content;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getAppointDate() {
		return appointDate;
	}

	public void setAppointDate(String appointDate) {
		this.appointDate = appointDate;
	}

}
