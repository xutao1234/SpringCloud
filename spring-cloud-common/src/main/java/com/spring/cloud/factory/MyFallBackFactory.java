package com.spring.cloud.factory;

import com.spring.cloud.api.EmployeeRemoteService;
import com.spring.cloud.entity.Employee;
import com.spring.cloud.util.ResultEntity;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 * 实现Consumer端服务降级功能
 * 实现FallbackFactory接口时要传入@FeignClient注解标记的接口类型
 * 在create()方法中返回@FeignClient注解标记的接口类型的对象，当Provider调用失败后，会执行这个对象的对应方法
 * 这个类必须使用@Component注解将当前类的对象加入IOC容器，当然当前类必须能够被扫描到
 */

@Component
public class MyFallBackFactory implements FallbackFactory<EmployeeRemoteService> {
    public EmployeeRemoteService create(final Throwable cause) {
        return new EmployeeRemoteService() {
            public Employee getEmployeeRemote() {
                return null;
            }

            public List<Employee> getEmpListRemote(String keyword) {
                return null;
            }

            public ResultEntity<Employee> getEmpWithCircuitBreaker(String signal) {
                return ResultEntity.failed("降级机制生效："+cause.getMessage());
            }
        };
    }
}
