package com.caogen.jfd.common;

import com.google.gson.Gson;

/**
 * 静态常量
 * 
 * @author Spuiln
 *
 */
public class Constants {

	public static final Gson gson = new Gson();
	// 请求报文参数
	public static final String REQUEST_TOKEN = "desc";
	public static final String REQUEST_HEAD = "code";
	public static final String REQUEST_BODY = "data";
	// 替换请求路径所需参数
	public static final String PATH_TARGET = "/api";
	public static final String PATH_REPLACEMENT = "";
	// 解密方式
	public static final String DECODE_DEFAULT = "00";
	public static final String DECODE_SECRETKEY = "01";
	// 3DES算法初始值
	public static final String DES_KEY = "FFFFFFFFFFFFFFFFFFFFFFFF";
	public static final String DES_IV = "00000000";
	// DH算法初始值
	public static final String DH_G = "2";
	public static final String DH_P = "DD0387E3EB70D68129358BCDB048327A6A69F0FF0895C639E1579F8C4B53933A78C8BD9D733987D62CE3BEB980E579A3A950B88EEC99C5611EB17195418CAE851BFF4C27B762373C9C18508981FDCA80FDEF8303F58403BBD6FEF0CB3D80B78781F4B9E3D6D77D2BCC68E5D39D72A25E0BFD03C6A4F31887263BB571A93BD12";
	// 密钥截取数据
	public static final int IV_START = 0;
	public static final int IV_END = 8;
	public static final int KEY_START = 8;
	public static final int KEY_END = 32;
	// 高德地图参数
	public static final String GD_KEY = "d1c70a488b4a9827f31bcb20668b48a0";
	public static final String GD_DISTANCE_URL = "https://restapi.amap.com/v3/distance";
	public static final String GD_DISTANCE_TYPE = "1";

}
