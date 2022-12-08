package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.repositories.ICurrentForecastRespository;


@Service
public class CurrentForecastImpl implements ICurrentForecast {

    private ICurrentForecastRespository currentForecastRepository;

    @Autowired
    public CurrentForecastImpl(ICurrentForecastRespository currentForecastRepository) {
        this.currentForecastRepository = currentForecastRepository;
    }


    @Override
    public void createCurrentForecast(CurrentForecast currentForecast) {
        this.currentForecastRepository.save(currentForecast);

    }

    @Override
    public void updateCurrentForecast(CurrentForecast currentForecast) {
        this.currentForecastRepository.save(currentForecast);
    }

    @Override
    public CurrentForecast getCurrentForecastByCityId(Long cityId) {
        return currentForecastRepository.findByCityId(cityId);
    }

    @Override
    public CurrentForecast getById(Long currentForecastId) {
        return currentForecastRepository.findById(currentForecastId).get();
    }


}
