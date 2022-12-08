package com.desi.SmnApp.services;

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

		


}
