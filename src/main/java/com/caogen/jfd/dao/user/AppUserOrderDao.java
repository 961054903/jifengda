package com.caogen.jfd.dao.user;

import java.util.List;

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

	/**
	 * 查询info表
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserOrder> findUnderway(AppUserOrder entity);

	/**
	 * 查询history表
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserOrder> findFinish(AppUserOrder entity);

}
