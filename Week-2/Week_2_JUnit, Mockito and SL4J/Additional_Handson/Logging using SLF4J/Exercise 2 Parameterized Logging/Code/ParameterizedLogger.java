package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ParameterizedLogger {
	private static final Logger logger=LoggerFactory.getLogger(ParameterizedLogger.class);

    public static void main(String[] args) {
        String username="maharaja";
        int userId =101;

        logger.info("User {} has logged in with ID {}", username, userId);
        logger.warn("User {} attempted invalid access at {}", username, System.currentTimeMillis());
        logger.error("Error occurred for user ID {}", userId);
    }
}
