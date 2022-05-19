package com.techreturner.metWeatherApi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MetWeatherApiApplication {

    /* Using the builder pattern here to construct the GroupedOpenApi instance.
		It is a way of choosing how to build (construct) the GroupedOpenApi object by specifying
		some construction steps.
		The Special Builder object helps with the process of constructing.
	 */
    @Bean
    public GroupedOpenApi swaggerConfiguration() {
        return GroupedOpenApi.builder()
                .group("weather-api")
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public OpenAPI metWeatherInfoApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Weather API")
                        .description("This API will help you prepare for the weather today!")
                        .version("v1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }


    public static void main(String[] args) {
        SpringApplication.run(MetWeatherApiApplication.class, args);


    }

}