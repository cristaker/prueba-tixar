package com.ticxar.pruebaticxar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.ticxar.pruebaticxar.client")
public class PruebaTicxarApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTicxarApplication.class, args);
    }
}

