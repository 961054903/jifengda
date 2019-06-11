package com.caogen.jfd.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
	private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	private static final String algorithmName = "md5";
	private static final int hashIterations = 2;

	/**
	 * 生成盐
	 * 
	 * @return
	 */
	public static String generateSalt() {
		return randomNumberGenerator.nextBytes().toHex();
	}

	/**
	 * 加密密码
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String encryptPassword(String password, String salt) {
		return new SimpleHash(algorithmName, password, ByteSource.Util.bytes(salt), hashIterations).toHex();
	}
}
