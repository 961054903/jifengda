package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserPath;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserPathService extends BaseService<AppUserPath> {
	/**
	 * 查询
	 * 
	 * @param entity
	 * @return
	 */
	AppUserPath getOne(AppUserPath entity);

	/**
	 * 查询全部
	 * 
	 * @param path
	 * @return
	 */
	List<AppUserPath> getAll(AppUserPath entity);

	/**
	 * 统计订单数量
	 * 
	 * @param path
	 * @return
	 */
	Integer count(AppUserPath path);

}
