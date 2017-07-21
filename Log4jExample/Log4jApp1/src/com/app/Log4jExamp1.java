package com.app;

import org.apache.log4j.Logger;

public class Log4jExamp1 {

	static Logger log = Logger.getLogger(Log4jExamp1.class);
	
	public static void main(String[] args) {
		
        log.debug("I am in degug");
		log.info("I am in info");
		log.warn("I am in warn");
		log.error("I am in error");
		log.fatal("I am in fatal");
		
	}

}
