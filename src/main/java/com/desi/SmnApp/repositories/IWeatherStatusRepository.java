package com.desi.SmnApp.repositories;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.WeatherStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWeatherStatusRepository extends JpaRepository<WeatherStatus, Long> {
    List<WeatherStatus> findAll();
}