package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.service.BaseService;

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
	 * 根据起终点计算价格、距离
	 * 
	 * @param origin
	 * @param destination
	 */
	void calculate(AppUserSite origin, AppUserSite[] destination);

}
