package com.caogen.jfd.entity.driver;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Complete implements Serializable {

    private static final long serialVersionUID = -3963307114992366647L;
    private Integer id; //id
    private Integer user_id;//用户id
    private Integer model_id;//车辆型号id
    private String code;//订单号
    private LocalDateTime create_date;//创建时间
    private Integer status;//订单状态 0：待付款；1：待接单；2：已接单；3：已取货；4：已完成；5：已取消；6：已退款
    private Peservation.Type type; //'订单类型：单点订单、多点订单',
    private Peservation.Mode mode;//订单模式：普通订单、预约订单
    private LocalDateTime appoint_date;//预约时间
    private String label;//订单标签：改派订单、投诉订单、抢单订单、平台分配
    private String origin;//发货地址
    private String destination;//收货地址
    private String name;//货物名称
    private Double night_cost;//夜间服务费
    private Double jam_cost;//高峰期加价
    private Boolean is_support; //是否保价
    private Double support_money;//保价金额
    private Double support_cost;//保价费用
    private Double order_money;//订单金额
    private Double ticket_money;//红包金额
    private Double actually_paid;//实付金额
    private Integer driver_id;//司机id
    private Double kilometer;//公里
    private Double bonus;//提成
    private LocalDateTime finish_date;//结束时间
    private Boolean is_evaluate;//是否评价
    private Integer evaluate_grade;//评价分数
    private String evaluate_content;//评价内容
    private Integer Total;//所有订单
    private Integer cc;
    private String phone;
    private Boolean aa;
    private String start;//开始时间
    private String end;//结束时间
    private String tim;
    private String createDate;
    private String Finishdate;
    private Double order;
    private String city;
    private Peservation.Payment payment;
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Peservation.Payment getPayment() {
        return payment;
    }

    public void setPayment(Peservation.Payment payment) {
        this.payment = payment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Complete{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", model_id=" + model_id +
                ", code='" + code + '\'' +
                ", create_date=" + create_date +
                ", status=" + status +
                ", type=" + type +
                ", mode=" + mode +
                ", appoint_date=" + appoint_date +
                ", label='" + label + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", name='" + name + '\'' +
                ", night_cost=" + night_cost +
                ", jam_cost=" + jam_cost +
                ", is_support=" + is_support +
                ", support_money=" + support_money +
                ", support_cost=" + support_cost +
                ", order_money=" + order_money +
                ", ticket_money=" + ticket_money +
                ", actually_paid=" + actually_paid +
                ", driver_id=" + driver_id +
                ", kilometer=" + kilometer +
                ", bonus=" + bonus +
                ", finish_date=" + finish_date +
                ", is_evaluate=" + is_evaluate +
                ", evaluate_grade=" + evaluate_grade +
                ", evaluate_content='" + evaluate_content + '\'' +
                ", Total=" + Total +
                ", cc=" + cc +
                ", phone='" + phone + '\'' +
                ", aa=" + aa +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", tim='" + tim + '\'' +
                ", createDate='" + createDate + '\'' +
                ", Finishdate='" + Finishdate + '\'' +
                ", order=" + order +
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

    public Peservation.Type getType() {
        return type;
    }

    public void setType(Peservation.Type type) {
        this.type = type;
    }

    public Peservation.Mode getMode() {
        return mode;
    }

    public void setMode(Peservation.Mode mode) {
        this.mode = mode;
    }

    public LocalDateTime getAppoint_date() {
        return appoint_date;
    }

    public void setAppoint_date(LocalDateTime appoint_date) {
        this.appoint_date = appoint_date;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
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

    public Double getKilometer() {
        return kilometer;
    }

    public void setKilometer(Double kilometer) {
        this.kilometer = kilometer;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public LocalDateTime getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(LocalDateTime finish_date) {
        this.finish_date = finish_date;
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

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getAa() {
        return aa;
    }

    public void setAa(Boolean aa) {
        this.aa = aa;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTim() {
        return tim;
    }

    public void setTim(String tim) {
        this.tim = tim;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getFinishdate() {
        return Finishdate;
    }

    public void setFinishdate(String finishdate) {
        Finishdate = finishdate;
    }

    public Double getOrder() {
        return order;
    }

    public void setOrder(Double order) {
        this.order = order;
    }
}