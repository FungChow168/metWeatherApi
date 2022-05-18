package com.techreturner.metWeatherApi.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Locale;

public class Accessories {

    private String temp;
    private String feels_like;
    private String temp_min;
    private String temp_max;
    private String description;
    private String suggestions;
    private String location;

    public Accessories(String temp, String feels_like, String temp_min, String temp_max, String description, String location) {
        this.temp = this.convertKelvinToCentigrade(temp);
        this.feels_like = this.convertKelvinToCentigrade(feels_like);
        this.temp_min = this.convertKelvinToCentigrade(temp_min);
        this.temp_max = this.convertKelvinToCentigrade(temp_max);
        this.description = description;
        this.location = location;
        this.giveSuggestion();
    }

    private String convertKelvinToCentigrade (String kelvin){
        DecimalFormat formatter = new DecimalFormat("##.0");
        return  formatter.format(Float.parseFloat(kelvin) - 273.15f);
    }

    private void giveSuggestion(){
        StringBuilder advice = new StringBuilder();
        if (Float.parseFloat(temp) >= 30)
            advice.append("You should bring a bottle of water. ");
        else if (Float.parseFloat(temp) >= 20)
            advice.append("Have some ice cream. ");
        else if (Float.parseFloat(temp) >= 10)
            advice.append("Put on a jacket. ");
        else if (Float.parseFloat(temp) >= 0)
            advice.append("You need a beanie, scarf, hat, coat and glove. ");
        else
            advice.append("Very cold, better to stay indoor. ");

        if (description.toUpperCase().equals("SUNNY"))
            advice.append("Sunshine is everywhere, put on your sunglasses.");
        else if (description.toUpperCase().equals("RAIN"))
            advice.append("Remember to bring your umbrella.");

        suggestions = advice.toString();
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public String getJsonString(){
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNodes = mapper.createObjectNode();
        jsonNodes.put("temp", temp);
        jsonNodes.put("feels_like", feels_like);
        jsonNodes.put("temp_min", temp_min);
        jsonNodes.put("temp_max", temp_max);
        jsonNodes.put("description", description);
        jsonNodes.put("location", location);
        jsonNodes.put("suggestions", suggestions);
        return jsonNodes.toPrettyString();
    }


}
