package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside Main");

        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode();           
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry(); // Will delete the "XY" country added earlier
        testFindCountryByPartialName("Uni");

        testFindCountryByCode("IN");      
        testFindCountryByCode("XX");       
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start testGetAllCountries");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End testGetAllCountries");
    }

    private static void testFindCountryByCode() {
        LOGGER.info("Start testFindCountryByCode");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode");
    }

    private static void testFindCountryByCode(String code) {
        LOGGER.info("Start testFindCountryByCode for: {}", code);
        try {
            Country country = countryService.findCountryByCode(code);
            LOGGER.debug("Country: {}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End testFindCountryByCode for: {}", code);
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country country = new Country();
        country.setCode("XY");
        country.setName("Xyland");

        countryService.addCountry(country);
        LOGGER.debug("Added Country: {}", country);

        try {
            Country retrievedCountry = countryService.findCountryByCode("XY");
            LOGGER.debug("Retrieved Country After Adding: {}", retrievedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found after adding: {}", e.getMessage());
        }

        LOGGER.info("End testAddCountry");
    }

    private static void testUpdateCountry() {
        LOGGER.info("Start testUpdateCountry");
        try {
            countryService.updateCountry("XY", "Xyland Renamed");
            Country updatedCountry = countryService.findCountryByCode("XY");
            LOGGER.debug("Updated Country: {}", updatedCountry);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("XY"); // deleting the same country added earlier
        LOGGER.info("Deleted Country with code XY");
        LOGGER.info("End testDeleteCountry");
    }

    private static void testFindCountryByPartialName(String keyword) {
        LOGGER.info("Start testFindCountryByPartialName");
        List<Country> countries = countryService.findCountryByNameContaining(keyword);
        LOGGER.debug("Matching Countries: {}", countries);
        LOGGER.info("End testFindCountryByPartialName");
    }
}
