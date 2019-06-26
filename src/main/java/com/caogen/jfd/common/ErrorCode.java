package com.caogen.jfd.common;

/**
 * 错误信息
 * 
 */
public enum ErrorCode {
	SUCCEED("0000", "操作成功"), 
	FAIL("1000", "操作失败"),
	PARAM_MISSING("1001", "参数缺失"),
	PARAM_ILLEGALITY("1002", "参数格式有误"),
	FIRST_LOGIN("1003", "该第三方第一次登录，需携带手机号和验证码"),
	
	LOGIN_ERROR("1010", "登录失败"),
	LOGIN_USER_ERROR("1011", "用户不存在或状态异常"),
	LOGIN_PASSWORD_ERROR("1012", "账号或密码错误"),
	SMS_MISMATCHING("1013", "验证码不匹配"),
	SMS_PAST("1014", "验证码已过期"),
	SMS_INEXISTENCE("1015", "验证码不存在"),
	SMS_SEND_ERROR("1016", "验证码发送异常"),
	
	SIGNIN_ERROR("1020", "密钥交换失败"),
	ISSUE_ERROR("1030", "问题反馈操作异常"),
	SITE_ERROR("1040", "常用地址操作异常"), 
	PATH_ERROR("1050", "常用路线操作异常"),
	INFO_ERROR("1060", "用户信息操作异常"), 
	CIPHER_ERROR("1070", "修改密码操作异常"), 
	LOGOUT_ERROR("1080", "用户退出操作异常"), 
	TICKET_ERROR("1090", "用户红包操作异常"), 
	DETAIL_ERROR("1100", "用户账户明细操作异常"), 
	ORDER_ERROR("1110", "用户订单操作异常"),
	
	END("1018","已抢完"),
	SUCCESS("1019","抢单成功");

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
