package com.desi.SmnApp.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToOne
	private CurrentForecast currentForecast;
	
	@OneToMany(targetEntity = ExtendedForecast.class)
	private  List<ExtendedForecast> extendedForecast;

	public City() {
		super();
	}
	
	public City(int id, String name, CurrentForecast currentForecast, List<ExtendedForecast> extendedForecast) {
		super();
		this.id = id;
		this.name = name;
		this.currentForecast = currentForecast;
		this.extendedForecast = extendedForecast;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CurrentForecast getCurrentForecast() {
		return currentForecast;
	}

	public void setCurrentForecast(CurrentForecast currentForecast) {
		this.currentForecast = currentForecast;
	}

	public List<ExtendedForecast> getExtendedForecast() {
		return extendedForecast;
	}

	public void setExtendedForecast(List<ExtendedForecast> extendedForecast) {
		this.extendedForecast = extendedForecast;
	}
}