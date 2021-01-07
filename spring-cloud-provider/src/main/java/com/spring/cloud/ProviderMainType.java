package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
// 使用@EnableCircuitBreaker注解开启断路器功能
@EnableCircuitBreaker

@SpringBootApplication
public class ProviderMainType {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMainType.class,args);
    }
}
