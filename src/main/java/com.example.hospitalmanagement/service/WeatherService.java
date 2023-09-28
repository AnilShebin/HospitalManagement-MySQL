package com.example.hospitalmanagement.service;

import com.example.hospitalmanagement.entity.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.hospitalmanagement.exception.WeatherApiException;

@Service
public class WeatherService {
    @Value("${weather.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String city) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("q", city)
                .queryParam("appid", apiKey);

        ResponseEntity<WeatherData> response = restTemplate.getForEntity(builder.toUriString(), WeatherData.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new WeatherApiException("Weather data not found for the specified city");
        }
    }
}
