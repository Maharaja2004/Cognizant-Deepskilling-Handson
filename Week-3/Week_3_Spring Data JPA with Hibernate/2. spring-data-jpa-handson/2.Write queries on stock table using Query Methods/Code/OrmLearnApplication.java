package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.StockRepository;

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
        StockRepository stockRepository = context.getBean(StockRepository.class);

        // HANDS-ON 1 TESTS
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry(); // Deletes "XY"
        testFindCountryByPartialName("Uni");
        testFindCountryByCode("IN");
        testFindCountryByCode("XX");
        testFindCountryByNameContainingSorted("ou");
        testFindCountriesStartingWith("Z");

        // HANDS-ON 2 TESTS
        testFacebookStockInSep2019(stockRepository);
        testGoogleStockPriceGreaterThan1250(stockRepository);
        testTop3HighestVolume(stockRepository);
        testLowestNetflixStocks(stockRepository);
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
        countryService.deleteCountry("XY");
        LOGGER.info("Deleted Country with code XY");
        LOGGER.info("End testDeleteCountry");
    }

    private static void testFindCountryByPartialName(String keyword) {
        LOGGER.info("Start testFindCountryByPartialName");
        List<Country> countries = countryService.findCountryByNameContaining(keyword);
        LOGGER.debug("Matching Countries: {}", countries);
        LOGGER.info("End testFindCountryByPartialName");
    }

    private static void testFindCountryByNameContainingSorted(String keyword) {
        LOGGER.info("Start testFindCountryByNameContainingSorted");
        List<Country> countries = countryService.findCountryByNameContainingSorted(keyword);
        LOGGER.debug("Sorted Matching Countries: {}", countries);
        LOGGER.info("End testFindCountryByNameContainingSorted");
    }

    private static void testFindCountriesStartingWith(String alphabet) {
        LOGGER.info("Start testFindCountriesStartingWith");
        List<Country> countries = countryService.findCountriesStartingWith(alphabet);
        LOGGER.debug("Countries starting with '{}': {}", alphabet, countries);
        LOGGER.info("End testFindCountriesStartingWith");
    }

    // ---------- HANDS-ON 2 TEST METHODS BELOW ----------

    private static void testFacebookStockInSep2019(StockRepository stockRepository) {
        LOGGER.info("Start testFacebookStockInSep2019");
        List<Stock> stocks = stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30)
        );
        LOGGER.debug("Facebook stock in Sep 2019: {}", stocks);
        LOGGER.info("End testFacebookStockInSep2019");
    }

    private static void testGoogleStockPriceGreaterThan1250(StockRepository stockRepository) {
        LOGGER.info("Start testGoogleStockPriceGreaterThan1250");
        List<Stock> stocks = stockRepository.findByCodeAndCloseGreaterThan("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("Google stocks with price > 1250: {}", stocks);
        LOGGER.info("End testGoogleStockPriceGreaterThan1250");
    }

    private static void testTop3HighestVolume(StockRepository stockRepository) {
        LOGGER.info("Start testTop3HighestVolume");
        List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
        LOGGER.debug("Top 3 highest volume stocks: {}", stocks);
        LOGGER.info("End testTop3HighestVolume");
    }

    private static void testLowestNetflixStocks(StockRepository stockRepository) {
        LOGGER.info("Start testLowestNetflixStocks");
        List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
        LOGGER.debug("Lowest Netflix stocks: {}", stocks);
        LOGGER.info("End testLowestNetflixStocks");
    }
}
