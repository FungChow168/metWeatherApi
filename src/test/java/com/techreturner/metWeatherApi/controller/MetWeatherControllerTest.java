package com.techreturner.metWeatherApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.techreturner.metWeatherApi.service.MetWeatherApiServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
public class MetWeatherControllerTest {

    @Mock
    private MetWeatherApiServiceImpl metWeatherApiServiceImpl;

    @InjectMocks
    private MetWeatherApiController metWeatherApiController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;
    private ObjectNode jsonNodes;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(metWeatherApiController).build();
        mapper = new ObjectMapper();
        jsonNodes = mapper.createObjectNode();
    }

    @Test
    public void testGgetForecast() throws Exception {

        jsonNodes.put("temp", 15.7);
        jsonNodes.put("feels_like", 15.1);
        jsonNodes.put("temp_min", 14.6);
        jsonNodes.put("temp_max", 17.4);
        jsonNodes.put("description", "overcast clouds");
        jsonNodes.put("location", "Reading");
        jsonNodes.put("suggestions", "Put on a jacket. ");

        when(metWeatherApiServiceImpl.getForecast("Reading")).thenReturn(jsonNodes.toPrettyString());

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/getForecast?location=Reading"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.temp").value(15.7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.location").value("Reading"));
    }

}
