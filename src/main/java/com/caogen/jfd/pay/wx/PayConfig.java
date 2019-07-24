package com.caogen.jfd.pay.wx;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;

import com.github.wxpay.sdk.WXPayConfig;

/**
 * 
 * @author Spuiln
 *
 */
public class PayConfig implements WXPayConfig {

	private static final String APP_ID = "wx3c8ca807138bfa30";
	private static final String MCH_ID = "1487406822";
	private static final String KEY = "b7e7755269e58ad4e36c7361dc474a98";
	private static final int CONNECT_TIMEOUT = 6000;
	private static final int READ_TIMEOUT = 8000;
	private byte[] cert;

	public PayConfig() {
		super();
	}

	public PayConfig(String path) throws IOException {
		// 加载证书
		InputStream is = PayConfig.class.getClassLoader().getResourceAsStream(path);
		this.cert = IOUtils.toByteArray(is);
		is.close();
	}

	@Override
	public String getAppID() {
		return APP_ID;
	}

	@Override
	public String getMchID() {
		return MCH_ID;
	}

	@Override
	public String getKey() {
		return KEY;
	}

	@Override
	public InputStream getCertStream() {
		return new ByteArrayInputStream(this.cert);
	}

	@Override
	public int getHttpConnectTimeoutMs() {
		return CONNECT_TIMEOUT;
	}

	@Override
	public int getHttpReadTimeoutMs() {
		return READ_TIMEOUT;
	}

}
