package com.caogen.jfd.dao.user;

import com.caogen.jfd.dao.BaseDao;
import com.caogen.jfd.entity.user.AppUserOrder;

public interface AppUserOrderDao extends BaseDao<AppUserOrder> {
	/**
	 * 统计info表
	 * 
	 * @param entity
	 * @return
	 */
	Integer countInfo(AppUserOrder entity);

	/**
	 * 统计history表
	 * 
	 * @param entity
	 * @return
	 */
	Integer countHistory(AppUserOrder entity);

}
