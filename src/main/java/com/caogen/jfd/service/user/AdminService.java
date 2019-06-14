package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppUserThird.Thirdparty;

/**
 * 
 * @author Spuiln
 *
 */
public interface AdminService {
	/**
	 * 获取验证码
	 * 
	 * @param phone
	 */
	void generateSms(String phone);

	/**
	 * 对比验证码
	 * 
	 * @param phone
	 * @param sms
	 */
	void verifySms(String phone, String sms);

	/**
	 * 生成token
	 * 
	 * @param username
	 * @return
	 */
	String generateToken(String username);

	/**
	 * 创建用户
	 * 
	 * @param username
	 * @param referrer
	 */
	void createAppUser(String username, String referrer);

	/**
	 * 创建用户
	 * 
	 * @param thirdparty
	 * @param identifier
	 * @param portrait_url
	 * @param username
	 * @param referrer
	 */
	void createAppUser(Thirdparty thirdparty, String identifier, String portrait_url, String username, String referrer);

	/**
	 * 用户名+密码登录
	 * 
	 * @param username
	 * @param password
	 * @throws Exception
	 */
	void passwordLogin(String username, String password) throws Exception;

	/**
	 * 短信验证码登录
	 * 
	 * @param username
	 * @param sms
	 * @param referrer
	 * @throws Exception
	 */
	void smsLogin(String username, String sms, String referrer) throws Exception;

	/**
	 * 第三方应用授权登录
	 * 
	 * @param thirdparty
	 * @param identifier
	 * @param portrait_url
	 * @param username
	 * @param sms
	 * @param referrer
	 * @throws Exception
	 */
	void thirdpartyLogin(Thirdparty thirdparty, String identifier, String portrait_url, String username, String sms,
			String referrer) throws Exception;

}
