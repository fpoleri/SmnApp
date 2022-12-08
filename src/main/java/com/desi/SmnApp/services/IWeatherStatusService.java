package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.WeatherStatus;

import java.util.List;

public interface IWeatherStatusService {
    List<WeatherStatus> getAll();

    WeatherStatus getWeatherStatusById(Long idWeatherStatus);
}
