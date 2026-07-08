package com.cognizant.runner;

import com.cognizant.entity.Country;
import com.cognizant.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {

    private final CountryService countryService;

    @Autowired
    public AppRunner(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) {
        System.out.println("=== Spring Data JPA Quick Example ===");
        System.out.println("=== Demonstrating JPA Repository Operations ===");

        System.out.println("--- Adding Countries ---");
        countryService.addCountry(new Country("IN", "India", "New Delhi", 1400000000L));
        countryService.addCountry(new Country("US", "United States", "Washington DC", 331000000L));
        countryService.addCountry(new Country("UK", "United Kingdom", "London", 67000000L));
        countryService.addCountry(new Country("JP", "Japan", "Tokyo", 125000000L));
        countryService.addCountry(new Country("AU", "Australia", "Canberra", 25000000L));

        System.out.println("--- All Countries ---");
        List<Country> countries = countryService.getAllCountries();
        countries.forEach(System.out::println);

        System.out.println("--- Find Country by Code: IN ---");
        countryService.findCountryBasedOnCountryCode("IN");

        System.out.println("--- Adding New Country ---");
        countryService.addNewCountry("CA", "Canada", "Ottawa", 38000000L);

        System.out.println("--- Implement Services for Managing Country ---");
        countryService.implementServicesForManagingCountry();

        System.out.println("--- Countries with population > 100 million ---");
        countryService.getCountriesWithLargePopulation(100000000L).forEach(System.out::println);

        System.out.println("=== Spring Data JPA Demo Completed ===");
    }
}
