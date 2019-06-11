package com.caogen.jfd.model;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 5101995756325459110L;
	private Object data;
	private String code;
	private String desc;

	@Override
	public String toString() {
		return "Message [data=" + data + ", code=" + code + ", desc=" + desc + "]";
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
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
