package com.kce.weather.repository;

import com.kce.weather.entity.WeatherData;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherData, Long> {

    List<WeatherData> findByConds(String conds);

    List<WeatherData> findByTempmGreaterThan(Double temp);

    List<WeatherData> findByConds(String conds, Sort sort);
}