package com.example.fitlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class FitLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitLogApplication.class, args);
    }
}