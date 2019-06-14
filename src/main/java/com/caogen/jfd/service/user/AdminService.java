package com.caogen.jfd.service.user;

import com.caogen.jfd.entity.user.AppThird.Thirdparty;

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
	 * 生成token
	 * 
	 * @param username
	 * @param identity
	 * @return
	 */
	String generateToken(String username);

	/**
	 * 对比密码
	 * 
	 * @param username
	 * @param password
	 * @param identity
	 * @throws Exception
	 */
	void verifyPassword(String username, String password) throws Exception;

	/**
	 * 对比验证码
	 * 
	 * @param username
	 * @param code
	 * @throws Exception
	 */
	void verifySms(String username, String code) throws Exception;

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

}
