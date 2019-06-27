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
	public static LocalDateTime strToDateTime(String str) {
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
	 * 字符串转时间
	 * 
	 * @param str
	 * @return
	 */
	public static LocalDate strToDate(String str) {
		return LocalDate.parse(str, date);
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
	 * 字符串转时间
	 * 
	 * @param str
	 * @return
	 */
	public static LocalTime strToTime(String str) {
		return LocalTime.parse(str, time);
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
