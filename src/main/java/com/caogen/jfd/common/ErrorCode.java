package com.caogen.jfd.common;

/**
 * 错误信息
 * 
 */
public enum ErrorCode {
	SUCCEED("0000", "操作成功"), 
	FAIL("1000", "操作失败"),
	LOGIN_ERROR("1010", "登录失败"),
	LOGIN_PARAM_ERROR("1011", "登录参数错误");

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
