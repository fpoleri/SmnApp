package com.desi.SmnApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.SmnApp.entities.ExtendedForecast;
import com.desi.SmnApp.repositories.IExtendedForecastRepository;

@Service
public class ExtendedForecastImpl implements IExtendedForecast {
	
	private IExtendedForecastRepository extendedForecastRepository;
	
	@Autowired
	public ExtendedForecastImpl(IExtendedForecastRepository extendedForecastRepository) {
		this.extendedForecastRepository = extendedForecastRepository;
	}

	@Override
	public void createExtendedForecast(ExtendedForecast extendedForecast) {
		extendedForecastRepository.save(extendedForecast);
	}

}
