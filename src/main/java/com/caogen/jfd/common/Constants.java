package com.caogen.jfd.common;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 静态常量
 * 
 * @author Spuiln
 *
 */
public class Constants {

	// 请求报文参数
	public static final String REQUEST_TOKEN = "desc";
	public static final String REQUEST_HEAD = "code";
	public static final String REQUEST_BODY = "data";
	// 替换请求路径所需参数
	public static final String PATH_TARGET_USER = "/api";
	public static final String PATH_TARGET_DRIVER = "/app";
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

	// 订单状态
	public static final int ORDER_STATUS_PAYMENT = 0;// 待付款
	public static final int ORDER_STATUS_ACCEPT = 1;// 待接单
	public static final int ORDER_STATUS_FETCH = 2;// 待取货
	public static final int ORDER_STATUS_DISPATCHING = 3;// 配送中
	public static final int ORDER_STATUS_FINISH = 4;// 已完成
	public static final int ORDER_STATUS_CANCEL = 5;// 已完成
	public static final int ORDER_STATUS_REFUND = 6;// 已完成

	// 高德地图参数
	public static final String GD_KEY = "d1c70a488b4a9827f31bcb20668b48a0";
	public static final String GD_DISTANCE_URL = "https://restapi.amap.com/v3/distance";
	public static final String GD_DISTANCE_TYPE = "1";
	// 阿里云短信参数
	public static final String SMS_SIGN_NAME = "吉蜂达即配";
	public static final String SMS_TEMPLATE_CODE = "SMS_117610019";
	// 微信支付回调地址
	public static final String WXPAY_NOTIFY_URL = "http://47.95.122.231:8080/JFDService/wxpay/notify";
	// 支付宝支付回调地址
	public static final String ALI_NOTIFY_URL = "http://47.95.122.231:8080/JFDService/alipay/notify";
	// 通知后台及司机端
	public static final String NOTIFY_URL = "http://47.95.122.231:8080/JFDBackstage/order/push";

	// JSON日期格式化
	public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	public static final String FORMAT_TIME = "HH:mm:ss";
	public static final Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
				@Override
				public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
					return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(FORMAT_DATETIME)));
				}
			}).registerTypeAdapter(LocalDate.class, new JsonSerializer<LocalDate>() {
				@Override
				public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
					return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(FORMAT_DATE)));
				}
			}).registerTypeAdapter(LocalTime.class, new JsonSerializer<LocalTime>() {
				@Override
				public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
					return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern(FORMAT_TIME)));
				}
			}).registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
				@Override
				public LocalDateTime deserialize(JsonElement json, Type type,
						JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
					String datetime = json.getAsJsonPrimitive().getAsString();
					return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(FORMAT_DATETIME));
				}
			}).registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
				@Override
				public LocalDate deserialize(JsonElement json, Type type,
						JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
					String datetime = json.getAsJsonPrimitive().getAsString();
					return LocalDate.parse(datetime, DateTimeFormatter.ofPattern(FORMAT_DATE));
				}
			}).registerTypeAdapter(LocalTime.class, new JsonDeserializer<LocalTime>() {
				@Override
				public LocalTime deserialize(JsonElement json, Type type,
						JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
					String datetime = json.getAsJsonPrimitive().getAsString();
					return LocalTime.parse(datetime, DateTimeFormatter.ofPattern(FORMAT_TIME));
				}
			}).create();

}
