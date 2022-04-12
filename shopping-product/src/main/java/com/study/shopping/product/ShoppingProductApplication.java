package com.study.shopping.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

// springsession共享
@EnableRedisHttpSession
// 注册feign客户端
@EnableFeignClients(basePackages = "com.study.shopping.product.feign")
@SpringBootApplication
@EnableDiscoveryClient
public class ShoppingProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingProductApplication.class, args);
    }

}
