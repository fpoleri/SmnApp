package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.ExtendedForecast;

import java.sql.Date;
import java.util.List;

public interface ICurrentForecast {

    void createCurrentForecast(CurrentForecast currentForecast);

    void updateCurrentForecast(CurrentForecast currentForecast);

    CurrentForecast getCurrentForecastByCityId(Long idCity);

    CurrentForecast getById(Long currentForecastId);

    List<CurrentForecast> getAll();

    List<CurrentForecast> getByDate();

    Boolean doesExtendedForescastExists(Long cityId, Date date);

}
