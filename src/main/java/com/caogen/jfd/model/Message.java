package com.caogen.jfd.model;

import java.io.Serializable;

import com.caogen.jfd.common.ErrorCode;
import com.caogen.jfd.common.StaticLogger;

/**
 * 
 * @author Spuiln
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = 5101995756325459110L;
	private Object data;
	private String code;
	private String desc;

	public Message() {
		this(ErrorCode.SUCCEED);
	}

	public Message(ErrorCode error) {
		setErrorCode(error);
	}

	public void setErrorCode(ErrorCode error) {
		this.code = error.getCode();
		this.desc = error.getDesc();
	}

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

	public void setData(Object data, String key, String iv) throws Exception {
		setData(data);
		/*-
		if (data != null) {
			String plaintext = Constants.gson.toJson(data);
			StaticLogger.info(">>>>>>" + plaintext);
			this.data = SecretUtils.desedeEncode(plaintext, key, iv);
		}*/
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
