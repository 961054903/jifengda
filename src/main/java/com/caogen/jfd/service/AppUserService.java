package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppUser;

/**
 * 
 * @author Spuiln
 *
 */
public interface AppUserService extends BaseService<AppUser> {

	/**
	 * 根据token查询
	 * 
	 * @param token
	 * @return
	 */
	AppUser getByToken(String token);

	/**
	 * 根据用户名查询
	 * 
	 * @param username
	 * @param identity
	 * @return
	 */
	AppUser getByUsername(String username, AppUser.Identity identity);

}
