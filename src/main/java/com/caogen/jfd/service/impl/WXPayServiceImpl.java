package com.caogen.jfd.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caogen.jfd.common.Constants;
import com.caogen.jfd.dao.user.AppUserDetailDao;
import com.caogen.jfd.dao.user.AppUserOrderDao;
import com.caogen.jfd.entity.AppUserDetail;
import com.caogen.jfd.entity.AppUserOrder;
import com.caogen.jfd.entity.AppUserDetail.Type;
import com.caogen.jfd.exception.WXPayException;
import com.caogen.jfd.pay.wx.PayConfig;
import com.caogen.jfd.service.WXPayService;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayUtil;

@Service
public class WXPayServiceImpl implements WXPayService {
	@Autowired
	private AppUserOrderDao orderDao;
	@Autowired
	private AppUserDetailDao detailDao;

	private static WXPayConfig config = new PayConfig();
	private static WXPay wxPay = new WXPay(config);

	@Override
	public Map<String, String> unifiedOrder(Map<String, String> reqData) throws Exception {
		reqData.put("appid", config.getAppID());
		reqData.put("mch_id", config.getMchID());
		reqData.put("nonce_str", getRandomNumber());
		reqData.put("spbill_create_ip", getHostAddress());
		reqData.put("notify_url", Constants.WXPAY_NOTIFY_URL);
		String sign = WXPayUtil.generateSignature(reqData, config.getKey());
		reqData.put("sign", sign);
		Map<String, String> resData = wxPay.unifiedOrder(reqData);
		checkSign(resData);
		if (!resData.get("result_code").equals("SUCCESS")) {
			throw new WXPayException(resData.get("err_code_des"));
		}
		Map<String, String> result = new HashMap<String, String>();
		result.put("appid", resData.get("appid"));
		result.put("partnerid", resData.get("mch_id"));
		result.put("noncestr", getRandomNumber());
		result.put("prepayid", resData.get("prepay_id"));
		result.put("timestamp", String.valueOf(new Date().getTime() / 1000));
		result.put("package", "Sign=WXPay");
		sign = WXPayUtil.generateSignature(result, config.getKey());
		result.put("sign", sign);
		return result;
	}

	@Override
	public Map<String, String> orderQuery(String out_trade_no) throws Exception {
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("appid", config.getAppID());
		reqData.put("mch_id", config.getMchID());
		reqData.put("out_trade_no", out_trade_no);
		reqData.put("nonce_str", getRandomNumber());
		String sign = WXPayUtil.generateSignature(reqData, config.getKey());
		reqData.put("sign", sign);
		Map<String, String> resData = wxPay.orderQuery(reqData);
		checkSign(resData);
		if (!resData.get("result_code").equals("SUCCESS")) {
			throw new WXPayException(resData.get("err_code_des"));
		}
		return resData;
	}

	@Override
	public Map<String, String> closeOrder(String out_trade_no) throws Exception {
		Map<String, String> reqData = new HashMap<String, String>();
		reqData.put("appid", config.getAppID());
		reqData.put("mch_id", config.getMchID());
		reqData.put("out_trade_no", out_trade_no);
		reqData.put("nonce_str", getRandomNumber());
		String sign = WXPayUtil.generateSignature(reqData, config.getKey());
		reqData.put("sign", sign);
		Map<String, String> resData = wxPay.closeOrder(reqData);
		checkSign(resData);
		if (!resData.get("result_code").equals("SUCCESS")) {
			throw new WXPayException(resData.get("err_code_des"));
		}
		return resData;
	}

	@Override
	public void notify(Map<String, String> resData) throws Exception {
		checkSign(resData);
		if (resData.get("result_code").equals("SUCCESS")) {
			String code = resData.get("out_trade_no");
			if (resData.get("attach").equals("outgoing")) {// 支付
				// 更新订单状态
				AppUserOrder order = orderDao.get(new AppUserOrder(code));
				order.setStatus(Constants.ORDER_STATUS_ACCEPT);
				orderDao.update(order);
				// 添加消费记录
				AppUserDetail detail = new AppUserDetail();
				detail.setUser_id(order.getUser_id());
				detail.setCreate_date(LocalDateTime.now());
				detail.setMoney(Integer.valueOf(resData.get("total_fee")) * 0.01);
				detail.setTitle("微信");
				detail.setDescription(code);
				detail.setAvailable(true);
				detail.setType(Type.outgoing);
				detailDao.insert(detail);
			} else {// 充值
				// 更新消费记录
				AppUserDetail entity = new AppUserDetail();
				entity.setDescription(code);
				entity = detailDao.get(entity);
				entity.setAvailable(true);
				detailDao.update(entity);
				// 更新余额
				
			}
		}
	}

	@Override
	public Map<String, String> refund(Map<String, String> reqData) throws Exception {
		// TODO

		String sign = WXPayUtil.generateSignature(reqData, config.getKey());
		reqData.put("sign", sign);
		Map<String, String> resData = wxPay.refund(reqData);
		checkSign(resData);
		if (!resData.get("result_code").equals("SUCCESS")) {
			throw new WXPayException(resData.get("err_code_des"));
		}
		return resData;
	}

	private void checkSign(Map<String, String> resData) throws Exception {
		if (!resData.get("return_code").equals("SUCCESS")) {
			throw new WXPayException(resData.get("return_msg"));
		}
		String sign1 = resData.remove("sign");
		String sign2 = WXPayUtil.generateSignature(resData, config.getKey());
		if (!sign1.equals(sign2)) {
			throw new WXPayException("sign error");
		}
	}

	// 随机字符串，小于32位
	private String getRandomNumber() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	// 支持IPV4和IPV6两种格式的IP地址
	private String getHostAddress() throws UnknownHostException {
		return InetAddress.getLocalHost().getHostAddress().toString();
	}

}
