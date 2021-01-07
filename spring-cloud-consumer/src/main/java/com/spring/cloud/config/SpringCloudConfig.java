package com.spring.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
@Configuration
public class SpringCloudConfig {

    // 这个注解让Restemplate有负载均衡的功能，通过调用Ribbon访问Provider集群
    @LoadBalanced
    @Bean
    public RestTemplate getResTemplage(){
        return new RestTemplate();
    }
}
