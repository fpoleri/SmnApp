package com.desi.SmnApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desi.SmnApp.entities.City;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<City, Long> {
	
	List<City> findAll();
}

