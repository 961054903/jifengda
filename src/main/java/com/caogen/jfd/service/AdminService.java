package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppThird.Thirdparty;
import com.caogen.jfd.entity.AppUser.Identity;

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
	String generateToken(String username, Identity identity);

	/**
	 * 对比密码
	 * 
	 * @param username
	 * @param password
	 * @param identity
	 * @throws Exception
	 */
	void verifyPassword(String username, String password, Identity identity) throws Exception;

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
	 * @param identity
	 * @param referrer
	 */
	void createAppUser(String username, Identity identity, String referrer);

	/**
	 * 创建用户
	 * 
	 * @param thirdparty
	 * @param identifier
	 * @param portrait_url
	 * @param username
	 * @param identity
	 * @param referrer
	 */
	void createAppUser(Thirdparty thirdparty, String identifier, String portrait_url, String username,
			Identity identity, String referrer);

}
