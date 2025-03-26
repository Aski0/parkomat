package com.example.parkomat.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig {
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // Ścieżki API, do których stosujemy CORS
                        .allowedOrigins("http://localhost:5174") // Domena, która może wykonywać żądania
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozwolone metody
                        .allowedHeaders("*") // Pozwolenie na dowolne nagłówki
                        .allowCredentials(true); // Zezwalanie na przesyłanie ciastek i tokenów
            }
        };
    }
}
