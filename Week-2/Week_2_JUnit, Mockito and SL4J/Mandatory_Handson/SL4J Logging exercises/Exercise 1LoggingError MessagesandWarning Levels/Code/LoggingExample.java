package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingExample {
	
	private static final Logger logger=LoggerFactory.getLogger(LoggingExample.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        logger.error("This is an error message");
        logger.warn("This is a warning message");
	}

}
