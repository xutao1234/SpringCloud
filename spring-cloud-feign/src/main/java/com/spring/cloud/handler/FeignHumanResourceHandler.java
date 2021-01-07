package com.spring.cloud.handler;

import java.util.List;
import com.spring.cloud.api.EmployeeRemoteService;
import com.spring.cloud.entity.Employee;
import com.spring.cloud.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
@RestController
public class FeignHumanResourceHandler {
    // 装配调用远程微服务的接口，后面向调用本地方法一样直接使用
    @Autowired
    private EmployeeRemoteService employeeRemoteService;

    @RequestMapping("/feign/consumer/test/fallback")
    public ResultEntity<Employee> testFallback(@RequestParam("signal") String signal){
        return employeeRemoteService.getEmpWithCircuitBreaker(signal);
    }

    @RequestMapping("/feign/consumer/get/emp")
    public Employee getEmployeeRemote(){
        return employeeRemoteService.getEmployeeRemote();
    }

    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(String keyword){
        return employeeRemoteService.getEmpListRemote(keyword);
    }
}
