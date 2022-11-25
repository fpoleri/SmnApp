package com.desi.SmnApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CurrentForecast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int temp;
	
	private int humidity;
	
	@OneToOne
	private WeatherStatus weatherStatus;

	public CurrentForecast() {
		super();
	}

	public CurrentForecast(int id, int temp, int humidity, WeatherStatus weatherStatus) {
		super();
		this.id = id;
		this.temp = temp;
		this.humidity = humidity;
		this.weatherStatus = weatherStatus;
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public WeatherStatus getWeatherStatus() {
		return weatherStatus;
	}

	public void setWeatherStatus(WeatherStatus weatherStatus) {
		this.weatherStatus = weatherStatus;
	}
}
