package com.techreturner.metWeatherApi.controller;

import com.techreturner.metWeatherApi.service.MetWeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/api/v1")
public class MetWeatherApiController {

    @Autowired
    MetWeatherApiService metWeatherApiService;



    @GetMapping({"/getForecast"})
    public ResponseEntity<String> getForecast(@RequestParam String location) throws IOException, InterruptedException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        return ResponseEntity.ok().headers(httpHeaders).body(metWeatherApiService.getForecast(location));
    }

    @GetMapping({"/info"})
    public ResponseEntity<String> getInfo() throws IOException, InterruptedException {

        return new ResponseEntity<String>("How to use this API: To get the weather details for a location, enter the name of the city or country in the location field.", HttpStatus.OK);

    }

}
