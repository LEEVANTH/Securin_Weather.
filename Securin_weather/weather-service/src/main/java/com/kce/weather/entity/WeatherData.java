package com.kce.weather.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "weather_data")
public class WeatherData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datetimeUtc;
    private String conds;
    private Double tempm;
    private Double hum;
    private Double pressurem;
    private Double wspdm;
    private Double precipm;
    private String wdire;
    private Double vism;
}

