package com.kce.weather.controller;

import com.kce.weather.entity.WeatherData;
import com.kce.weather.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping
    public List<WeatherData> getAll(
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        if (sortBy != null) {
            return service.getAllSorted(sortBy, direction);
        }

        return service.getAll();
    }

    @GetMapping("/condition")
    public List<WeatherData> getByCondition(@RequestParam String conds) {
        return service.getByCondition(conds);
    }

    @GetMapping("/temp")
    public List<WeatherData> getHotWeather(@RequestParam Double temp) {
        return service.getHotWeather(temp);
    }
}