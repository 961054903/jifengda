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
	SITE_ERROR("1010", "常用地址操作异常");

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
