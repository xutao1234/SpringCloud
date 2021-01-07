package com.spring.cloud.handler;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.cloud.entity.Employee;
import com.spring.cloud.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
@RestController
public class EmployeeHandler {

    private Logger logger = LoggerFactory.getLogger(EmployeeHandler.class);

    // @HystrixCommand注解指定当前方法出问题时调用的备份方法（使用fallbackMethod属性指定）
    @HystrixCommand(fallbackMethod = "getEmpWithCircuitBreakerBackup")
    @RequestMapping("/provider/get/emp/with/circuit/breaker")
    public ResultEntity<Employee> getEmpWithCircuitBreaker(@RequestParam("signal") String signal) throws InterruptedException {

        if("quick-bang".equals(signal)){
            throw new RuntimeException();
        }

        if("slow-bang".equals(signal)){
            Thread.sleep(5000);
        }

        return ResultEntity.successWithData(new Employee(666,"empName666",66.66));
    }

    public ResultEntity<Employee> getEmpWithCircuitBreakerBackup(@RequestParam("signal") String signal){

        String message="方法执行出现问题，断路执行！signal=" + signal;

        return ResultEntity.failed(message);
    }



    @RequestMapping("/provider/get/emp/list/remote")
    public List<Employee> getEmpListRemote(@RequestParam("keyword") String keyword){
        logger.info("keyword="+keyword);

        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee(33,"empName33",33.33));
        empList.add(new Employee(44,"empName44",44.44));
        empList.add(new Employee(55,"empName55",55.55));

        return empList;
    }

    @RequestMapping("/provider/get/employee/remote")
    public Employee getEmployeeRemote(){

        return new Employee(555,"tom555",555.55);
    }

    //@RequestMapping("/provider/get/employee/remote")
    //public Employee getEmployeeRemote(HttpServletRequest request){
//
    //    // 获取当前服务的端口号
    //    int serverPort = request.getServerPort();
//
    //    return new Employee(555,"tom555 " + serverPort,555.55);
    //}
}
