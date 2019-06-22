package com.caogen.jfd.common;

/**
 * 错误信息
 * 
 */
public enum ErrorCode {
	SUCCEED("0000", "操作成功"), 
	FAIL("1000", "操作失败"),
	PARAM_MISSING("1100", "参数缺失"),
	PARAM_ILLEGALITY("1101", "参数格式有误"),
	LOGIN_ERROR("1001", "登录失败"),
	LOGIN_PARAM_ERROR("1002", "登录参数错误"),
	LOGIN_USER_ERROR("1003", "用户不存在或状态异常"),
	LOGIN_PASSWORD_ERROR("1004", "账号或密码错误"),
	SMS_MISMATCHING("1005", "验证码错误"),
	SMS_PAST("1006", "验证码已过期"),
	SMS_INEXISTENCE("1007", "验证码不存在"),
	SIGNIN_ERROR("1008", "密钥交换失败"),
	ISSUE_ERROR("1009", "问题反馈操作异常"),
	SITE_ERROR("1010", "常用地址操作异常"), 
	PATH_ERROR("1011", "常用路线操作异常"),
	INFO_ERROR("1012", "用户信息操作异常"), 
	CIPHER_ERROR("1013", "修改密码操作异常"), 
	LOGOUT_ERROR("1014", "用户退出操作异常"), 
	TICKET_ERROR("1015", "用户红包操作异常"), 
	DETAIL_ERROR("1016", "用户账户明细操作异常"), 
	ORDER_ERROR("10017", "用户订单操作异常"),
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
