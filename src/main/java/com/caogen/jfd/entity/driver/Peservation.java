package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Peservation implements Serializable {

    private static final long serialVersionUID = -3973307114992366647L;
    private Integer id; //id
    private Integer user_id;//用户id
    private Integer model_id;//车辆型号id
    private String code;//订单号
    private LocalDateTime create_date;//创建时间
    private Integer status;//订单状态 0：待付款；1：待接单；2：已接单；3：已取货；4：已完成；5：已取消；6：已退款
    private Type type; //'订单类型：单点订单、多点订单',
    private Mode mode;//订单模式：普通订单、预约订单
    private LocalDateTime appoint_date;//预约时间
    private Label label;//订单标签：改派订单、投诉订单、抢单订单、平台分配
    private String origin;//发货地址
    private String destination;//收货地址
    private String name;//货物名称
    private Double night_service_cost;//夜间服务费
    private Double traffic_jam_cost;//高峰期加价
    private Boolean is_support; //是否保价
    private Double support_money;//保价金额
    private Double support_cost;//保价费用
    private Double order_money;//订单金额
    private Double ticket_money;//红包金额
    private Double actually_paid;//实付金额
    private Integer driver_id;//司机id
    private Double kilometre;//公里
    private Double bonus;//提成


    public enum Type {
        single, multiple
    }

    public enum Mode {
        common, appoint
    }

    public enum Label {
        none, change, complain,rob,distribution
    }

    @Override
    public String toString() {
        return "Peservation{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", model_id=" + model_id +
                ", code='" + code + '\'' +
                ", create_date=" + create_date +
                ", status=" + status +
                ", type=" + type +
                ", mode=" + mode +
                ", appoint_date=" + appoint_date +
                ", label=" + label +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", name='" + name + '\'' +
                ", night_service_cost=" + night_service_cost +
                ", traffic_jam_cost=" + traffic_jam_cost +
                ", is_support=" + is_support +
                ", support_money=" + support_money +
                ", support_cost=" + support_cost +
                ", order_money=" + order_money +
                ", ticket_money=" + ticket_money +
                ", actually_paid=" + actually_paid +
                ", driver_id=" + driver_id +
                ", kilometre=" + kilometre +
                ", bonus=" + bonus +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Integer driver_id) {
        this.driver_id = driver_id;
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
}