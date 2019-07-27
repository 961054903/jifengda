package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserOrder;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserOrderService extends BaseService<AppUserOrder> {
	/**
	 * 统计订单数量
	 * 
	 * @param entity
	 * @return
	 */
	Integer count(AppUserOrder entity);

	/**
	 * 
	 * @param order
	 * @return
	 */
	List<AppUserOrder> getUnderway(AppUserOrder entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserOrder> getFinish(AppUserOrder entity);

	/**
	 * 查询
	 * 
	 * @param entity
	 * @return
	 */
	AppUserOrder getOne(AppUserOrder entity);

	/**
	 * 评价订单
	 * 
	 * @param order
	 */
	void evaluate(AppUserOrder order);

	/**
	 * 计算距离
	 * 
	 * @param order
	 */
	void calculateDistance(AppUserOrder order);

	/**
	 * 计算价格
	 * 
	 * @param order
	 */
	void calculatePrice(AppUserOrder order);

}
