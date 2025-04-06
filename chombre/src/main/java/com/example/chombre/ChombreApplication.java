package com.example.chombre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.example.chombre"})
@EntityScan(basePackages = {"com.example.chombre.entity"})
@EnableJpaRepositories(basePackages = {"com.example.chombre.repository"})
public class ChombreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChombreApplication.class, args);
    }
} 