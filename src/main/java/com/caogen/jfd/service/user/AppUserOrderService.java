package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserOrder;
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
	 * 查询全部
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserOrder> getAll(AppUserOrder entity);

}
