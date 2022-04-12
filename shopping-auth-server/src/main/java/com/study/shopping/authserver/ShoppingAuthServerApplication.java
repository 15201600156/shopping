package com.study.shopping.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


// 注册feign客户端
@EnableFeignClients(basePackages = "com.study.shopping.authserver.feign")
@EnableDiscoveryClient
@SpringBootApplication
@EnableRedisHttpSession
public class ShoppingAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingAuthServerApplication.class, args);
    }

}
