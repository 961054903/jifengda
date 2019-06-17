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
	 * 
	 * @param entity
	 * @return
	 */
	AppUserSite getOne(AppUserSite entity);

	/**
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUserSite> getList(AppUserSite entity);

}
