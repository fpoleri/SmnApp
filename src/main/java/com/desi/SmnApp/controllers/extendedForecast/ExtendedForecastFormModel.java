package com.desi.SmnApp.controllers.extendedForecast;

import java.sql.Date;


public class ExtendedForecastFormModel {
    private Long id;
    private String name;
    private Long idCity;
    private Date date;
    private int rainProbability;
    private int predictedRain;
    private String description;

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        if (name != null && name.length() > 0)
            return name;
        else
            return null;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
