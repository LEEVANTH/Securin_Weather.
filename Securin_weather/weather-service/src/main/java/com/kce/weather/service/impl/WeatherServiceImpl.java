package com.kce.weather.service.impl;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kce.weather.entity.WeatherData;
import com.kce.weather.repository.WeatherRepository;
import com.kce.weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    public WeatherServiceImpl(WeatherRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<WeatherData> getAll() {
        return repository.findAll();
    }

    @Override
    public List<WeatherData> getAllSorted(String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        return repository.findAll(sort);
    }

    @Override
    public List<WeatherData> getByCondition(String conds) {
        return repository.findByConds(conds);
    }

    @Override
    public List<WeatherData> getHotWeather(Double temp) {
        return repository.findByTempmGreaterThan(temp);
    }
}
