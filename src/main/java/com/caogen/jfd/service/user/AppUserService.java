package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUser;
import com.caogen.jfd.entity.user.AppUserSms;
import com.caogen.jfd.entity.user.AppUserThird;
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
	 * 对比验证码
	 * 
	 * @param phone
	 * @param sms
	 * @throws Exception
	 */
	void verifySms(String phone, String sms) throws Exception;

	/**
	 * 用户名+密码登录
	 * 
	 * @param user
	 * @return token
	 * @throws Exception
	 */
	String loginByPassword(AppUser user) throws Exception;

	/**
	 * 短信验证码登录
	 * 
	 * @param user
	 * @param sms
	 * @return
	 * @throws Exception
	 */
	String loginBySms(AppUser user, AppUserSms sms) throws Exception;

	/**
	 * 第三方应用授权登陆
	 * 
	 * @param user
	 * @param sms
	 * @param third
	 * @return
	 * @throws Exception
	 */
	String loginByThird(AppUser user, AppUserSms sms, AppUserThird third) throws Exception;

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

}
