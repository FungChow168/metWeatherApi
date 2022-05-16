package com.techreturner.metWeatherApi.controller;

//import com.techreturners.bookmanager.model.Book;
//import com.techreturners.bookmanager.service.BookManagerService;
import com.techreturner.metWeatherApi.service.MetWeatherApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class MetWeatherApiController {

    @Autowired
    MetWeatherApiService metWeatherApiService;

    @GetMapping
    public ResponseEntity<String> testing(){return new ResponseEntity<String>("Hello World",HttpStatus.OK);};

    @GetMapping({"/getForecast"})
    public ResponseEntity<String> getForcast(@RequestParam String location){
        return new ResponseEntity<String>(metWeatherApiService.getForecast(location), HttpStatus.OK);
    }

}
