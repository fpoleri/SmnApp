package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.ExtendedForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.repositories.ICurrentForecastRespository;

import java.sql.Date;
import java.util.List;
import java.util.Objects;


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
    public CurrentForecast getById(Long currentForecastId) {
        return currentForecastRepository.findById(currentForecastId).get();
    }

    @Override
    public List<CurrentForecast> getAll() {
        return currentForecastRepository.findAll();
    }

    @Override
    public List<CurrentForecast> getByDate() {
        return currentForecastRepository.findByDate();
    }

    @Override
    public Boolean doesExtendedForescastExists(Long cityId, Date date) {
        return Objects.nonNull(currentForecastRepository.findByCityIdAndDate(cityId, date));
    }


}
