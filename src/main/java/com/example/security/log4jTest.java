package com.example.security;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2021/12/18 22:08
 * @Description:
 */
@RestController
public class log4jTest {
    private static final Logger LOG = LogManager.getLogger(log4jTest.class);
    public static void main(String[] args) {
        //System.setProperty("com.sun.jndi.rmi.object.trustURLCodebase", "true");
//        System.setProperty("java.rmi.server.useCodebaseOnly", "false");
        LOG.error("main 方法测试--> {}","${java:vm}");
    }

    @GetMapping("/log4jTest")
    public String queryEmpContr(){
        String name ="${java:vm}";
        LOG.error("hi {}",name);

        return "log4jTest";
    }
}
