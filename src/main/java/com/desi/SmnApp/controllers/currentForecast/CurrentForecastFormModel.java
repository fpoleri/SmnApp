package com.desi.SmnApp.controllers.currentForecast;


import com.desi.SmnApp.entities.City;
import com.desi.SmnApp.entities.WeatherStatus;

import java.sql.Date;

public class CurrentForecastFormModel {
    private Long id;

    private int temp;

    private int humidity;

    private Date date;

    private Long idCity;


    private Long idWeatherStatus;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
