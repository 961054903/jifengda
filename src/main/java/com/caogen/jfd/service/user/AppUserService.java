package com.caogen.jfd.service.user;

import java.util.List;

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

	/**
	 * 密钥交换
	 * 
	 * @param A
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	String[] exchangeKey(String A, String phone) throws Exception;

	/**
	 * 更改密码
	 * 
	 * @param username
	 * @param password
	 */
	void changePassword(String username, String password);

	/**
	 * 查询下级
	 * 
	 * @param entity
	 * @return
	 */
	List<AppUser> getLowerList(AppUser entity);

}
