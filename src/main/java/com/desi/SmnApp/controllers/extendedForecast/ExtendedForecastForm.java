package com.desi.SmnApp.controllers.extendedForecast;

import java.sql.Date;

import com.desi.SmnApp.entities.ExtendedForecast;

public class ExtendedForecastForm {
	
	private Long id;
	private Long idCity;
	private Date selectedDate;
	private int rainProbability;
	private int predictedRain;
	private String description;
	

	public ExtendedForecastForm() {
		super();
	}
	
	public ExtendedForecastForm(ExtendedForecast e) {
		super();
		this.id=e.getId();
		this.selectedDate=e.getDate();
		this.rainProbability = e.getRainProbability();
		this.predictedRain = e.getPredictedRain();
		this.description = e.getDescription();
		this.idCity=e.getCity().getId();
	}

	public ExtendedForecast toPojo()
	{
		ExtendedForecast e = new ExtendedForecast();
		e.setId(this.id);
		e.setDate(this.getSelectedDate());
		e.setPredictedRain(this.getPredictedRain());
		e.setRainProbability(this.getRainProbability());
		e.setDescription(this.getDescription());
		return e;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getSelectedDate() {
		return selectedDate;
	}
	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
	public int getRainProbability() {
		return rainProbability;
	}
	public void setRainProbability(int rainProbability) {
		this.rainProbability = rainProbability;
	}
	public int getPredictedRain() {
		return predictedRain;
	}
	public void setPredictedRain(int predictedRain) {
		this.predictedRain = predictedRain;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getIdCity() {
		return idCity;
	}
	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}
}
