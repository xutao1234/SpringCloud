package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */

// 启用Zuul的网关代理功能
@EnableZuulProxy
@SpringBootApplication
public class ZuulMainType {
    public static void main(String[] args) {
        SpringApplication.run(ZuulMainType.class,args);
    }
}
