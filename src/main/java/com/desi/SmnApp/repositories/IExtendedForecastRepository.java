package com.desi.SmnApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.SmnApp.entities.ExtendedForecast;

import java.util.List;

@Repository
public interface IExtendedForecastRepository extends JpaRepository<ExtendedForecast, Long> {
	
	List<ExtendedForecast> findByCityId(Long cityId);
	List<ExtendedForecast> findAll();
	
}
