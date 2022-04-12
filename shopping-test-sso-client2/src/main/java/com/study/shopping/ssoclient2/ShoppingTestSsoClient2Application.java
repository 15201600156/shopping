package com.study.shopping.ssoclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
@SpringBootApplication
public class ShoppingTestSsoClient2Application {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingTestSsoClient2Application.class, args);
    }

}
