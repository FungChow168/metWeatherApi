package com.techreturner.metWeatherApi.service;

import org.springframework.stereotype.Service;

@Service
public class MetWeatherApiServiceImpl implements MetWeatherApiService{

    @Override
    public String getForecast(String location){
        return String.format("%s is sunny", location);
    }

    public Long getLocationId(){

    }

    public String getForecast(){

    }

}

