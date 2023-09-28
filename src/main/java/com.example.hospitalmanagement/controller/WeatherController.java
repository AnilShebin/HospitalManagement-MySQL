package com.example.hospitalmanagement.controller;

import com.example.hospitalmanagement.entity.WeatherData;
import com.example.hospitalmanagement.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherData> getWeather(@RequestParam(name = "city") String city) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        return ResponseEntity.ok(weatherData);
    }
}
