package com.cognizant.spring_learn.service;

import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countryList = (List<Country>) context.getBean("countryList");

		return countryList.stream()
			.filter(c -> c.getCode().equalsIgnoreCase(code))
			.findFirst()
			.orElseThrow(CountryNotFoundException::new);
	}
}
