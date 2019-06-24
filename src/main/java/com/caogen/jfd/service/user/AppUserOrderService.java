package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserOrder;
import com.caogen.jfd.entity.user.AppUserOrder.Type;
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
	 * 计算距离
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	int getDistance(AppUserSite origin, AppUserSite[] destination);

	/**
	 * 计算价格
	 * 
	 * @param model_id
	 * @param type
	 * @param distance
	 * @return
	 */
	double getPrice(Integer model_id, Type type, int distance);

}
