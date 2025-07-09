package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class AppendersExample {
	private static final Logger logger = LoggerFactory.getLogger(AppendersExample.class);

    public static void main(String[] args) {
        logger.info("Logging INFO level message to console and file");
        logger.debug("Logging DEBUG level message to console and file");
        logger.error("Logging ERROR level message to console and file");
    }
}
