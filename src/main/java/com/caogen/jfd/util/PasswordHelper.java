package com.caogen.jfd.util;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class PasswordHelper {
	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String generateNumber() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	/**
	 * 生成盐
	 * 
	 * @return
	 */
	public static String generateSalt() {
		return RandomStringUtils.random(32, "0123456789ABCDEF");
	}

	/**
	 * 生成验证码
	 * 
	 * @return
	 */
	public static String generateCode() {
		return RandomStringUtils.random(4, "0123456789");
	}

	/**
	 * 加密密码
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encryptPassword(String password, String salt) {
		return DigestUtils.md5Hex(password + salt);
	}
}
