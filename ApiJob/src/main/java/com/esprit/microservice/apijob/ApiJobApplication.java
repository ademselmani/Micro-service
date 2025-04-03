package com.esprit.microservice.apijob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiJobApplication.class, args);
    }


}
