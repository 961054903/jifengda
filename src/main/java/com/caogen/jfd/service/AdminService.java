package com.caogen.jfd.service;

import com.caogen.jfd.entity.AppUser.Identity;

/**
 * 
 * @author Spuiln
 *
 */
public interface AdminService {

	/**
	 * 生成token
	 * 
	 * @param username
	 * @param identity
	 * @return
	 */
	String generateToken(String username, Identity identity);

	/**
	 * 生成验证码
	 * 
	 * @param phone
	 */
	void generateSms(String phone);

	void password(String username, String password);

}
