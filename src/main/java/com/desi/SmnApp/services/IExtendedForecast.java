package com.desi.SmnApp.services;

import com.desi.SmnApp.entities.ExtendedForecast;

import java.util.List;

public interface IExtendedForecast {
	
	void createExtendedForecast(ExtendedForecast extendedForecast);
	
	void updateExtendedForecast(ExtendedForecast extendedForecast);
	
	List<ExtendedForecast> getExtendedForecastByCityId(Long cityId);
	
	ExtendedForecast getById(Long extendedForecastId);
}
