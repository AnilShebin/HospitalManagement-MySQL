package com.example.hospitalmanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {
    private TemperatureData main;
    private Weather[] weather;

    public TemperatureData getMain() {
        return main;
    }

    public void setMain(TemperatureData main) {
        this.main = main;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }
}
