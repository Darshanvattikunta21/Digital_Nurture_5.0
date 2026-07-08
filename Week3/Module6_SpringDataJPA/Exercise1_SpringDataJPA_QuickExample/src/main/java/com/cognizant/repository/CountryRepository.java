package com.cognizant.repository;

import com.cognizant.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByCountryCode(String countryCode);

    List<Country> findByCountryName(String countryName);

    @Query("SELECT c FROM Country c WHERE c.population > :population")
    List<Country> findCountriesWithPopulationGreaterThan(@Param("population") Long population);

    @Query("SELECT c FROM Country c ORDER BY c.countryName ASC")
    List<Country> findAllOrderedByName();

    List<Country> findByCapital(String capital);
}
