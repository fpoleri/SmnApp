package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.ExtendedForecast;

import java.util.List;

public interface ICurrentForecast {

    void createCurrentForecast(CurrentForecast currentForecast);

    void updateCurrentForecast(CurrentForecast currentForecast);

    CurrentForecast getCurrentForecastByCityId(Long cityId);

    CurrentForecast getById(Long currentForecastId);
}
