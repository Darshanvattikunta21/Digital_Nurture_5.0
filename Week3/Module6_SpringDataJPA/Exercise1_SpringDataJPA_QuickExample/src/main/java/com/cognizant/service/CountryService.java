package com.cognizant.service;

import com.cognizant.entity.Country;
import com.cognizant.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryByCode(String code) {
        return countryRepository.findByCountryCode(code);
    }

    public Country addCountry(Country country) {
        Country saved = countryRepository.save(country);
        System.out.println("Country added: " + country.getCountryName());
        return saved;
    }

    public Country updateCountry(Long id, Country updated) {
        return countryRepository.findById(id)
                .map(existing -> {
                    existing.setCountryCode(updated.getCountryCode());
                    existing.setCountryName(updated.getCountryName());
                    existing.setCapital(updated.getCapital());
                    existing.setPopulation(updated.getPopulation());
                    Country saved = countryRepository.save(existing);
                    System.out.println("Country updated: " + saved.getCountryName());
                    return saved;
                })
                .orElseThrow(() -> new IllegalArgumentException("Country not found with id: " + id));
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
        System.out.println("Country deleted with id: " + id);
    }

    public List<Country> getCountriesWithLargePopulation(Long minPop) {
        return countryRepository.findCountriesWithPopulationGreaterThan(minPop);
    }

    public void implementServicesForManagingCountry() {
        System.out.println("Implement services for managing Country");
        List<Country> countries = countryRepository.findAllOrderedByName();
        countries.forEach(country -> System.out.println("Manage country: " + country));
    }

    public void findCountryBasedOnCountryCode(String code) {
        Optional<Country> country = getCountryByCode(code);
        System.out.println("Find a country based on country code: " + code);
        country.ifPresentOrElse(
                c -> System.out.println(c),
                () -> System.out.println("Country not found with code: " + code)
        );
    }

    public void addNewCountry(String code, String name, String capital, Long population) {
        Country country = new Country(code, name, capital, population);
        addCountry(country);
        System.out.println("Add a new country: " + name);
    }
}
