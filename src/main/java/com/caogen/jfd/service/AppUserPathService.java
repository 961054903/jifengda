package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserPath;

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
	 * 统计路线数量
	 * 
	 * @param path
	 * @return
	 */
	Integer count(AppUserPath path);

}
