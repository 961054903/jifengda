package com.caogen.jfd.dao.user;

import java.util.List;

import com.caogen.jfd.entity.AppUserSite;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserSiteDao extends BaseDao<AppUserSite> {
	/**
	 * 
	 * @param model_id
	 * @return
	 */
	List<AppUserSite> findLocation(Integer model_id);

}
