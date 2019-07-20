package com.caogen.jfd.service;

import java.util.List;

import com.caogen.jfd.entity.AppUserDetail;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserDetailService extends BaseService<AppUserDetail> {
	/**
	 * 全部查询
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserDetail> getAll(AppUserDetail entity);

}
