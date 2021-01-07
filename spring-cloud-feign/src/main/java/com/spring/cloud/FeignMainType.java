package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
// 启用Feign客户端功能
@EnableFeignClients
@SpringBootApplication
public class FeignMainType {
    public static void main(String[] args) {
        SpringApplication.run(FeignMainType.class,args);
    }
}
