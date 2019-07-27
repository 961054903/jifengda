package com.caogen.jfd.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志记录器
 * 
 * @author Spuiln
 *
 */
public class StaticLogger {
	private static final Logger logger = LoggerFactory.getLogger(StaticLogger.class);

	public static Logger logger() {
		return logger;
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void debug(String msg) {
		logger.debug(msg);
	}

	public static void error(String msg, Throwable t) {
		logger.error(msg, t);
	}

}
