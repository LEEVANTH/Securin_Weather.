package com.kce.weather.loader;

import com.kce.weather.entity.WeatherData;
import com.kce.weather.repository.WeatherRepository;
import com.opencsv.CSVReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvLoader implements CommandLineRunner {

    private final WeatherRepository repository;

    public CsvLoader(WeatherRepository repository) {
        this.repository = repository;
    }

    private Double parseDouble(String value) {

        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.isEmpty() ||
                value.equalsIgnoreCase("N/A") ||
                value.equalsIgnoreCase("NA") ||
                value.equalsIgnoreCase("-9999")) {
            return null;
        }

        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null; 
        }
    }

    @Override
    public void run(String... args) throws Exception {

        
        if (repository.count() > 0) {
            System.out.println("Data already loaded.");
            return;
        }

        String filePath = "C:/Users/ladha/Downloads/testset.csv";

        CSVReader reader = new CSVReader(new FileReader(filePath));

        String[] line;
        reader.readNext(); 

        List<WeatherData> list = new ArrayList<>();

        while ((line = reader.readNext()) != null) {

            WeatherData data = new WeatherData();

            data.setDatetimeUtc(line[0]);
            data.setConds(line[1]);
            data.setTempm(parseDouble(line[11]));
            data.setHum(parseDouble(line[6]));
            data.setPressurem(parseDouble(line[8]));
            data.setWspdm(parseDouble(line[19]));
            data.setPrecipm(parseDouble(line[7]));
            data.setWdire(line[16]);
            data.setVism(parseDouble(line[14]));

            list.add(data);
        }

        repository.saveAll(list); 

        reader.close();

        System.out.println("CSV Loaded Successfully!");
    }
}