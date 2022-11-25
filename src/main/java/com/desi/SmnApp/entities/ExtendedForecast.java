package com.desi.SmnApp.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ExtendedForecast {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	private int rainProbability;
	
	private int predictedRain;
		
	private String description;
	
	@ManyToOne
	private City city;

	public ExtendedForecast() {
		super();
	}

	public ExtendedForecast(int id, Date date, int rainProbability, int predictedRain, String description, City city) {
		super();
		this.id = id;
		this.date = date;
		this.rainProbability = rainProbability;
		this.predictedRain = predictedRain;
		this.description = description;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
