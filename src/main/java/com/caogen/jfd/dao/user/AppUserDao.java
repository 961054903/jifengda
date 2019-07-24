package com.caogen.jfd.dao.user;

import java.util.List;

import com.caogen.jfd.entity.AppUser;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserDao extends BaseDao<AppUser> {
	/**
	 * 查询下级
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUser> findUnderling(AppUser entity);

}
