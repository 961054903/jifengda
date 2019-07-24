package com.caogen.jfd.service;

import java.util.Map;

import com.caogen.jfd.entity.AppUserOrder;

/**
 * 
 * @author Spuiln
 *
 */
public interface AliPayService {
	/**
	 * 下单
	 * 
	 * @param order
	 * @return
	 * @throws Exception
	 */
	String unifiedOrder(AppUserOrder order) throws Exception;

	/**
	 * 验证异步通知信息
	 * 
	 * @param params
	 * @return
	 */
	boolean notify(Map<String, String> params) throws Exception;

}
