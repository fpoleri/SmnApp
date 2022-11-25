package com.desi.SmnApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.SmnApp.entities.CurrentForecast;


@Repository
public interface ICurrentForecastRespository extends JpaRepository<CurrentForecast, Long> {

}
