package com.framework.base;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Loggers {

	public static Logger Log = Logger.getLogger(Log4JLogger.class.getName());

	public static void configureLog() {
		DOMConfigurator.configure("log4j.xml");
	}
	public static void getInfoLog(String msg) {
		Log.info(msg);
	}

}
