package com.caogen.jfd.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 加解密工具类
 * 
 * @author Spuiln
 *
 */
public class SecretUtils {

	private final static String charset = "UTF-8";
	private final static Base64 base = new Base64();

	/**
	 * 3DES/CBC加密
	 * 
	 * @param plaintext 明文
	 * @param secretKey 密钥
	 * @param iv        向量
	 * @return
	 * @throws Exception
	 */
	public static String desedeEncode(String plaintext, String secretKey, String iv) throws Exception {
		byte[] text = plaintext.getBytes(charset);
		byte[] encryptData = desede(text, secretKey, iv, Cipher.ENCRYPT_MODE);
		return base.encodeToString(encryptData);
	}

	/**
	 * 3DES/CBC解密
	 * 
	 * @param ciphertext 密文
	 * @param secretKey  密钥
	 * @param iv         向量
	 * @return
	 * @throws Exception
	 */
	public static String desedeDecode(String ciphertext, String secretKey, String iv) throws Exception {
		byte[] text = base.decode(ciphertext);
		byte[] decryptData = desede(text, secretKey, iv, Cipher.DECRYPT_MODE);
		return new String(decryptData, charset);
	}

	/**
	 * 3DES/CBC加解密，填充方式PKCS5
	 * 
	 * @param text      明文/密文 字节数组
	 * @param secretKey 密钥
	 * @param iv        向量
	 * @param mode      加解密模式
	 * @return
	 * @throws Exception
	 */
	private static byte[] desede(byte[] text, String secretKey, String iv, int mode) throws Exception {
		DESedeKeySpec spec = new DESedeKeySpec(secretKey.getBytes());
		SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
		Key deskey = keyfactory.generateSecret(spec);
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
		cipher.init(mode, deskey, ips);
		return cipher.doFinal(text);
	}

	/**
	 * Diffie-Hellman密钥交换算法
	 * 
	 * @param A_str
	 * @param g_str
	 * @param p_str
	 * @return
	 */
	public static String[] dh(String A_str, String g_str, String p_str, int b_number) {
		BigInteger A = new BigInteger(A_str, 16);
		BigInteger g = new BigInteger(g_str, 16);
		BigInteger p = new BigInteger(p_str, 16);
		String b_str = RandomStringUtils.random(b_number, "0123456789ABCDEF");
		BigInteger b = new BigInteger(b_str, 16);
		String B = g.modPow(b, p).toString(16).toUpperCase();
		String result = A.modPow(b, p).toString(16).toUpperCase();
		return new String[] { B, result };
	}

	/**
	 * Base64加密
	 * 
	 * @param plaintext
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Encode(String plaintext) throws UnsupportedEncodingException {
		return base.encodeToString(plaintext.getBytes(charset));
	}

	/**
	 * Base64解密
	 * 
	 * @param ciphertext
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String base64Decode(String ciphertext) throws UnsupportedEncodingException {
		return new String(base.decode(ciphertext), charset);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String str2hex(String str) {
		byte[] arr = str.getBytes();
		StringBuffer sb = new StringBuffer();
		for (byte b : arr) {
			sb.append(Integer.toHexString(b));
		}
		return sb.toString().toUpperCase();
	}

	/**
	 * 
	 * @param hex
	 * @return
	 */
	public static String hex2str(String hex) {
		int len = hex.length() / 2;
		byte[] arr = new byte[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return new String(arr);
	}

}
