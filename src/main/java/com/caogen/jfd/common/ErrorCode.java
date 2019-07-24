package com.caogen.jfd.common;

/**
 * 错误信息
 * 
 */
public enum ErrorCode {
	SUCCEED("0000", "操作成功"), 
	FAIL("0001", "操作失败"),
	PARAM_MISSING("0002", "参数缺失"),
	PARAM_ILLEGALITY("0003", "参数格式有误"),
	FIRST_LOGIN("0004", "该第三方账号第一次登录，请绑定手机号"),
	CITY_LIST_ERROR("0005", "获取城市列表失败"),
	INDUSTRY_LIST_ERROR("0006", "获取行业列表失败"),
	VERSION_ERROR("0007", "获取版本号失败失败"),
	
	LOGIN_ERROR("0100", "登录失败"),
	LOGIN_USER_ERROR("0101", "用户不存在或状态异常"),
	LOGIN_PASSWORD_ERROR("0102", "账号或密码错误"),
	SMS_MISMATCHING("0103", "验证码不匹配"),
	SMS_PAST("0104", "验证码已过期"),
	SMS_INEXISTENCE("0105", "验证码不存在"),
	SMS_SEND_ERROR("0106", "验证码发送异常"),
	SIGNIN_ERROR("0107", "密钥交换失败"),
	CIPHER_ERROR("0108", "修改密码操作异常"), 
	LOGOUT_ERROR("0109", "用户退出操作异常"), 
	
	WALLET_TICKET_ERROR("0201", "查询用户红包失败"), 
	WALLET_DETAIL_ERROR("0202", "查询用户账户明细失败"), 
	WALLET_BALANCE_ERROR("0203", "查询用户余额失败"),
	
	ISSUE_ERROR("0300", "问题反馈操作异常"),
	ISSUE_FAQ_ERROR("0301", "获取常见问题列表失败"),
	ISSUE_FEEDBACK_ERROR("0302", "提交问题反馈失败"),
	ISSUE_HISTORY_ERROR("0303", "获取历史反馈列表失败"),
	
	SITE_ERROR("0400", "常用地址操作异常"), 
	SITE_ADD_ERROR("0401", "添加常用地址失败"),
	SITE_DEL_ERROR("0402", "删除常用地址失败"),
	SITE_EDIT_ERROR("0403", "编辑常用地址失败"),
	SITE_QUERY_ERROR("0404", "查询常用地址失败"),
	
	PATH_ERROR("0500", "常用路线操作异常"),
	PATH_ADD_ERROR("0501", "添加常用路线失败"),
	PATH_DEL_ERROR("0502", "删除常用路线失败"),
	PATH_EDIT_ERROR("0503", "编辑常用路线失败"),
	PATH_QUERY_ERROR("0504", "查询常用路线失败"),
	
	INFO_ERROR("0600", "用户信息操作异常"), 
	INFO_ADD_ERROR("0601", "添加用户信息失败"),
	INFO_DEL_ERROR("0602", "删除用户信息失败"),
	INFO_EDIT_ERROR("0603", "编辑用户信息失败"),
	INFO_QUERY_ERROR("0604", "查询用户信息失败"),
	INFO_ALREADY_REAL("0605", "已实名认证"),
	
	ORDER_ERROR("0700", "用户订单操作异常"),
	ORDER_ADD_ERROR("0701", "添加订单失败"),
	ORDER_DEL_ERROR("0702", "删除订单失败"),
	ORDER_EDIT_ERROR("0703", "编辑订单失败"),
	ORDER_QUERY_ERROR("0704", "查询订单失败"),
	ORDER_CALCULATE_ERROR("0705", "计算距离、价格失败"),
	
	PAY_BALANCE_ERROR("0800","余额支付异常"),
	PAY_BALANCE_INSUFFICIENT("0801","余额不足"),
	PAY_WXPAY_ERROR("0810", "微信支付异常"),
	PAY_ALI_ERROR("0820", "支付宝支付异常"),
	;

	private String code;
	private String desc;

	private ErrorCode(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
