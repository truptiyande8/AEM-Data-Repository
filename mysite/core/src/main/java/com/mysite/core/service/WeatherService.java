package com.mysite.core.service;

import com.mysite.core.dto.WeatherResponse;

public interface WeatherService {

    WeatherResponse getWeather(String location);
}