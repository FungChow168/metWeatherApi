package com.techreturner.metWeatherApi.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MetWeatherApiServiceImpl implements MetWeatherApiService {


    @Override
    public String getForecast(String location) {


        ObjectMapper mapper = new ObjectMapper();
        Accessories accessories = null;
        String trimmedLocation = location.trim();

        final String prefix = "http://api.openweathermap.org/data/2.5/weather?q=";
        final String suffix = "&APPID=cf79806101d2e4cb25066d0d4b04ae56";

        HttpResponse<String> response = null;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(prefix + trimmedLocation + suffix))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404)
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, trimmedLocation + " is not on the location list.  Please check the spelling and try again.");
            JsonNode jsonNode = mapper.readTree(response.body());
            accessories = new Accessories(jsonNode.get("main").get("temp").toString()
                                          ,jsonNode.get("main").get("feels_like").toString()
                                            ,jsonNode.get("main").get("temp_min").toString()
                                        ,jsonNode.get("main").get("temp_max").toString()
                                        ,jsonNode.get("weather").get(0).get("description").toString().replace("\"", "")
                                        ,jsonNode.get("name").toString().replace("\"", ""));

        }catch(IOException | InterruptedException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error.", e);
        }
//        return response.body();
        return accessories.getJsonString();
    }

}

