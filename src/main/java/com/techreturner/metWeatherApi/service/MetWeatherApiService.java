package com.techreturner.metWeatherApi.service;

import java.io.IOException;

public interface MetWeatherApiService {

    String getForecast(String location) throws IOException, InterruptedException;

}
