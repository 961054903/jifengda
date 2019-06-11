package com.caogen.jfd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Spuiln
 *
 */
public class Industry implements Serializable {

	private static final long serialVersionUID = 4944887372530559693L;
	private String code;
	private String name;
	private List<Industry> children = new ArrayList<Industry>();

	public Industry() {
	}

	public Industry(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Industry [code=" + code + ", name=" + name + ", children=" + children + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Industry> getChildren() {
		return children;
	}

	public void setChildren(List<Industry> children) {
		this.children = children;
	}

}
