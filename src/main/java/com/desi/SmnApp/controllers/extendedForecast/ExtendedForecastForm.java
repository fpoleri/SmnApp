package com.desi.SmnApp.controllers.extendedForecast;

import java.sql.Date;

import com.desi.SmnApp.entities.ExtendedForecast;

import net.bytebuddy.utility.nullability.NeverNull;

public class ExtendedForecastForm {
	@NeverNull
	private Long id;
	@NeverNull
	private Long idCity;
	@NeverNull
	private Date selectedDate;
	@NeverNull
	private int rainProbability;
	@NeverNull
	private int predictedRain;
	@NeverNull
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
