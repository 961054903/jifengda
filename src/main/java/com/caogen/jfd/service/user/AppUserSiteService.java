package com.caogen.jfd.service.user;

import java.util.List;

import com.caogen.jfd.entity.user.AppUserSite;
import com.caogen.jfd.service.BaseService;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserSiteService extends BaseService<AppUserSite> {
	/**
	 * 查询
	 * 
	 * @param entity
	 * @return
	 */
	AppUserSite getOne(AppUserSite entity);

	/**
	 * 查询全部
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserSite> getAll(AppUserSite entity);

}
