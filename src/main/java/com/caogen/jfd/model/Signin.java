package com.caogen.jfd.model;

import java.io.Serializable;

/**
 * 
 * @author Spuiln
 *
 */
public class Signin implements Serializable {

	private static final long serialVersionUID = 5016521837718867112L;
	private String phone;
	private String result;
	private String verify;

	@Override
	public String toString() {
		return "Signin [phone=" + phone + ", result=" + result + ", verify=" + verify + "]";
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

}
