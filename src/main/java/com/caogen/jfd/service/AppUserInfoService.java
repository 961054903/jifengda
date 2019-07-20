package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppUserInfo;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserInfoService extends BaseService<AppUserInfo> {

	/**
	 * 查询
	 * 
	 * @param entity
	 * @return
	 */
	AppUserInfo getOne(AppUserInfo entity);

	/**
	 * 修改余额
	 * 
	 * @param entity
	 */
	void modifyBalance(AppUserInfo entity);

}
