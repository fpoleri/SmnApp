package com.desi.SmnApp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.repositories.ICityRepository;

@Service
public class CityServiceImpl implements ICityService {
	
	private ICityRepository cityRepository;
	
	@Autowired
	public CityServiceImpl(ICityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Override
	public List<City> getAll() {
		return cityRepository.findAll();
	}

}
