package com.cognizant.spring_learn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		LOGGER.info("START");
		SpringApplication.run(SpringLearnApplication.class, args);
		displayCountry();
		displayCountries();
		LOGGER.info("END");
	}

	public static void displayCountry() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);

		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Another Country : {}", anotherCountry.toString());

		LOGGER.info("END");
	}

	public static void displayCountries() {
		LOGGER.info("START");

		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		@SuppressWarnings("unchecked")
		ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");

		LOGGER.debug("Country List: {}", countryList);

		LOGGER.info("END");
	}
}
