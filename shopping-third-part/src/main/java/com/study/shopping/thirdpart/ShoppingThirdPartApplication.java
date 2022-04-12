package com.study.shopping.thirdpart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShoppingThirdPartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingThirdPartApplication.class, args);
    }

}
