package com.example.demo.controller;

import com.example.test_10.service.iml.LoginServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 21:38
 * @Description:
 */
@RestController
@Slf4j
public class TransactionController {
    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping("/transaction")
    @Transactional
    public String userAdd(String name, String password, String yespassword, String sex, HttpServletRequest request){
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();
        String requestURLstring = requestURL.toString();
        log.info("uri is {} contextPath is {} requestURL is {} requestURLstring is {}",uri,contextPath,requestURL,requestURLstring);
        String parameter = request.getParameter("password");
        log.info("parameter is {}",parameter);
       //获取请求体

        String message = loginServiceImp.addUser(name, password, yespassword, sex);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean equals = "9527".equals(password);
        System.out.println("-----"+equals);
        if ("9527".equals(password)) {
            log.info("RuntimeException");
            throw new RuntimeException("transaction异常");
        }
        return message;
    }

    @PostMapping("/transaction2")
    @Transactional
    public String userAdd2(String name, String password, String yespassword, String sex, HttpServletRequest request){
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        StringBuffer requestURL = request.getRequestURL();
        String requestURLstring = requestURL.toString();
        log.info("uri2 is {} contextPath is {} requestURL2 is {} requestURLstring2 is {}",uri,contextPath,requestURL,requestURLstring);
        String parameter = request.getParameter("password");
        log.info("parameter2 is {}",parameter);
        //获取请求体

        String message = loginServiceImp.addUser2(name, password, yespassword, sex);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean equals = "9527".equals(password);
        System.out.println("-----"+equals);
        if ("9527".equals(password)) {
            log.info("RuntimeException2");
            throw new RuntimeException("transaction异常2");
        }
        return message;
    }
}
