package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.service.BaseService;

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
	AppUser getByUsername(String username);

}
