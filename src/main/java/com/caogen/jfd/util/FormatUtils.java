package com.caogen.jfd.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Spuiln
 *
 */
public class FormatUtils {
	private static DateTimeFormatter datetime = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
	private static DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyyMMdd");
	private static DateTimeFormatter time = DateTimeFormatter.ofPattern("HHmmss");

	/**
	 * 字符串转时间
	 * 
	 * @param str
	 * @return
	 */
	public static LocalDateTime strToDate(String str) {
		return LocalDateTime.parse(str, datetime);
	}

	/**
	 * 时间转字符串
	 * 
	 * @return
	 */
	public static String dateToStr(LocalDateTime local) {
		return datetime.format(local);
	}

	/**
	 * 时间转字符串
	 * 
	 * @return
	 */
	public static String dateToStr(LocalDate local) {
		return date.format(local);
	}

	/**
	 * 时间转字符串
	 * 
	 * @return
	 */
	public static String dateToStr(LocalTime local) {
		return time.format(local);
	}
}
