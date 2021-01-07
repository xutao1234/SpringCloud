package com.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
// 启用仪表盘监控功能
@EnableHystrixDashboard
@SpringBootApplication
public class DashboardMainType {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMainType.class,args);
    }
}
