package com.dauphine.blogger.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // [cite: 126]
@EnableWebMvc // [cite: 127]
public class WebConfig implements WebMvcConfigurer {

    @Override // [cite: 129]
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:4200");
    }
}