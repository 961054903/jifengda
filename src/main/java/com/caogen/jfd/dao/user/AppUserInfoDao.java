package com.caogen.jfd.dao.user;

import com.caogen.jfd.entity.AppUserInfo;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserInfoDao extends BaseDao<AppUserInfo> {
	/**
	 * 更新余额
	 * 
	 * @param entity
	 */
	void updateBalance(AppUserInfo entity);

}
