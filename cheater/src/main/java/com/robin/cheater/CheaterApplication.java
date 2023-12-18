package com.robin.cheater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CheaterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheaterApplication.class, args);
    }
}
