package com.kce.weather.service;

import com.kce.weather.entity.WeatherData;
import java.util.List;

public interface WeatherService {

    List<WeatherData> getAll();

    List<WeatherData> getAllSorted(String sortBy, String direction);

    List<WeatherData> getByCondition(String conds);

    List<WeatherData> getHotWeather(Double temp);
}