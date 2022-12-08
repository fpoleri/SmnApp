package com.desi.SmnApp.controllers.currentForecast;

import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.CurrentForecast;
import com.desi.SmnApp.entities.WeatherStatus;

public class CurrentForecastForm {

    private Long id;
	
	private int temp;
	
	private int humidity;
	
	
	private Long idCity;
	

	private Long idWeatherStatus;


	public CurrentForecastForm() {
		super();
	}

	public CurrentForecastForm(CurrentForecast c) {
	
		this.id =c.getId();
		this.temp = c.getTemp();
		this.humidity = c.getHumidity();
		this.idCity = c.getCity().getId();
		this.idWeatherStatus = c.getWeatherStatus().getId();

	}

	
	public CurrentForecast toPojo() {
		CurrentForecast c = new CurrentForecast();
		c.setId(this.id);
		c.setTemp(this.temp);
		c.setHumidity(this.humidity);
		return c;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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




	public Long getIdCity() {
		return idCity;
	}




	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}




	public Long getIdWeatherStatus() {
		return idWeatherStatus;
	}




	public void setIdWeatherStatus(Long idWeatherStatus) {
		this.idWeatherStatus = idWeatherStatus;
	}


	



	
	
}
