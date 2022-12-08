package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.WeatherStatus;
import com.desi.SmnApp.repositories.IWeatherStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherStatusImpl implements IWeatherStatusService {

    private IWeatherStatusRepository weatherStatusRepository;

    @Autowired
    public WeatherStatusImpl(IWeatherStatusRepository weatherStatusRepository) {
        this.weatherStatusRepository = weatherStatusRepository;
    }

    @Override
    public List<WeatherStatus> getAll() {
        return weatherStatusRepository.findAll();
    }

    @Override
    public WeatherStatus getWeatherStatusById(Long idWeatherStatus) {
        return weatherStatusRepository.findById(idWeatherStatus).get();
    }
}
