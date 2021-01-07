package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */

// 启用Eureka服务器功能
@EnableEurekaServer
@SpringBootApplication
public class EurekaMainType {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMainType.class,args);
    }
}
