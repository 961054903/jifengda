package com.caogen.jfd.dao.user;

import com.caogen.jfd.entity.AppUserPath;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserPathDao extends BaseDao<AppUserPath> {
	/**
	 * 
	 * @param path
	 * @return
	 */
	Integer count(AppUserPath path);

}
