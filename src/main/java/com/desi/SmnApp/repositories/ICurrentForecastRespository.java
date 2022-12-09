package com.desi.SmnApp.repositories;

import com.desi.SmnApp.entities.ExtendedForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desi.SmnApp.entities.CurrentForecast;

import java.sql.Date;
import java.util.List;


@Repository
public interface ICurrentForecastRespository extends JpaRepository<CurrentForecast, Long> {
    CurrentForecast findByCityId(Long idCity);

    @Query("SELECT c FROM CurrentForecast c WHERE c.date = CURDATE()")
    List<CurrentForecast> findByDate();

    CurrentForecast findByCityIdAndDate(Long cityId, Date date);

}
