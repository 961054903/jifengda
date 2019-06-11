package com.caogen.jfd.shiro;

import java.io.Serializable;

/**
 * 自定义SimpleByteSource类， 解决org.apache.shiro.util.SimpleByteSource不能序列化的问题
 *
 */
public class SimpleByteSource extends org.apache.shiro.util.SimpleByteSource implements Serializable {

	private static final long serialVersionUID = 1491567845248L;

	public SimpleByteSource(byte[] bytes) {
		super(bytes);
	}

}
