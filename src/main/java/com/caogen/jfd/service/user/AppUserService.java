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
	 * 根据手机号查询
	 * 
	 * @param phone
	 * @return
	 */
	AppUser getByPhone(String phone);

	/**
	 * 密钥交换
	 * 
	 * @param A
	 * @param token
	 * @return
	 * @throws Exception
	 */
	String[] exchangeKey(String A, String token) throws Exception;

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
