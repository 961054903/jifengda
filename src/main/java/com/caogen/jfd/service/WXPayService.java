package com.caogen.jfd.service;

import java.util.Map;

public interface WXPayService {

	/**
	 * 统一下单
	 * 
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	Map<String, String> unifiedOrder(Map<String, String> reqData) throws Exception;

	/**
	 * 查询订单
	 * 
	 * @param out_trade_no 商户订单号
	 * @return
	 * @throws Exception
	 */
	Map<String, String> orderQuery(String out_trade_no) throws Exception;

	/**
	 * 关闭订单
	 * 
	 * @param out_trade_no 商户订单号
	 * @return
	 * @throws Exception
	 */
	Map<String, String> closeOrder(String out_trade_no) throws Exception;

	/**
	 * 支付结果通知
	 * 
	 * @param resData
	 * @throws Exception
	 */
	void notify(Map<String, String> resData) throws Exception;

	/**
	 * 申请退款
	 * 
	 * @param reqData
	 * @return
	 * @throws Exception
	 */
	Map<String, String> refund(Map<String, String> reqData) throws Exception;
}
