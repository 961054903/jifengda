package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUserInfo;
import com.caogen.jfd.service.BaseService;

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

}
