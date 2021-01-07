package com.spring.cloud.handler;

import com.spring.cloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: taotao
 * @Date: 2020/1/6 17:50
 * @Version 1.0
 */
@RestController
public class HumanResourceHandler {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/ribbon/get/remote")
    public Employee getEmployeeTemote(){
        // 1.声明远程微服务的主机地址加端口号
        //String host="http://localhost:1000";

        // 将远程微服务调用地址从“IP地址+端口号”改为“微服务名称”
        String host = "http://springcloud-provider";

        // 2.声明具体要调用的功能的url地址
        String url="/provider/get/employee/remote";

        return restTemplate.getForObject(host+url,Employee.class);
    }
}
