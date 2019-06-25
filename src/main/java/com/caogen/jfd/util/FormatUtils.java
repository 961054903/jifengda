package com.caogen.jfd.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Spuiln
 *
 */
public class FormatUtils {
	private static DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	/**
	 * 字符串转时间
	 * 
	 * @param str
	 * @return
	 */
	public static LocalDateTime strToDate(String str) {
		return LocalDateTime.parse(str, df);
	}

	/**
	 * 时间转字符串
	 * 
	 * @return
	 */
	public static String dateToStr(LocalDateTime time) {
		return df.format(time);
	}
}
