package com.avgona.citizencrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("com.avgona.citizencrud.controllers"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfo("Citizen CRUD API",
                "Citizen CRUD application",
                "1.00",
                "https://github.com/Avgona",
                new Contact("Vladyslav", "https://www.linkedin.com/in/w%C5%82adys%C5%82aw-parkhomenko-139709195/", "avgona2017@yandex.com"),
                "None licence", "none",
                Collections.emptyList());
    }
}
