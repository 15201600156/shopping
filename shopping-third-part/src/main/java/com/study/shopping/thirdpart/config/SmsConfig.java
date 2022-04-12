package com.study.shopping.thirdpart.config;

import com.study.shopping.thirdpart.service.impl.SmsServiceImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 短信配置类
 */
@Configuration
public class SmsConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.cloud.alicloud.sms")
    public SmsServiceImpl smsService() {
        return new SmsServiceImpl();
    }

}