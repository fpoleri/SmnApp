package com.desi.SmnApp.controllers.currentForecast;

import com.desi.SmnApp.entities.CurrentForecast;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class CurrentForecastForm {

    private Long id;
    @Min(0)
    private int temp;
    @Min(0)
    private int humidity;
    @NotNull(message = "La fecha no puede ser nula")
    private Date date;
    @NotNull(message = "Debes seleccionar una ciudad")
    private Long idCity;
    private Long idWeatherStatus;


    public CurrentForecastForm() {
    }

    public CurrentForecastForm(CurrentForecast c) {
        this.id = c.getId();
        this.temp = c.getTemp();
        this.humidity = c.getHumidity();
        this.date = c.getDate();
        this.idCity = c.getCity().getId();
        this.idWeatherStatus = c.getWeatherStatus().getId();
    }


    public CurrentForecast toPojo() {
        CurrentForecast c = new CurrentForecast();
        c.setId(this.id);
        c.setTemp(this.temp);
        c.setHumidity(this.humidity);
        c.setDate(this.getDate());
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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
