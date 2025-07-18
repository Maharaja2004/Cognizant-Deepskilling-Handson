package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside Main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode("IN");
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();
        testFindCountryByPartialName("Uni");
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void testFindCountryByCode(String code) {
        LOGGER.info("Start testFindCountryByCode");
        Country country = countryService.findCountryByCode(code);
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia");
        countryService.addCountry(country);
        LOGGER.debug("Added Country: {}", country);
        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        Country country = new Country();
        country.setCode("ZZ");
        country.setName("Zootopia Updated");
        countryService.updateCountry(country);
        LOGGER.debug("Updated Country: {}", country);
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("ZZ");
        LOGGER.info("Deleted Country with code ZZ");
        LOGGER.info("End testDeleteCountry");
    }

    private static void testFindCountryByPartialName(String keyword) {
        LOGGER.info("Start testFindCountryByPartialName");
        List<Country> countries = countryService.findCountryByNameContaining(keyword);
        LOGGER.debug("Matching Countries: {}", countries);
        LOGGER.info("End testFindCountryByPartialName");
    }
}
