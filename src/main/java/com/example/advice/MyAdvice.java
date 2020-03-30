package com.example.advice;

import com.example.demo.myException.MyException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 23:07
 * @Description:
 */
@RestControllerAdvice
@Slf4j
public class MyAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(MyAdvice.class);
    //捕获全局异常，处理所有不可知的异常
    @ExceptionHandler(value=Exception.class)
    public Object handleException(Exception e, HttpServletRequest request) {
        LOG.error("msg:{},url:{}", e.getMessage(), request.getRequestURL());

        Map<String, Object> map = new HashMap<>();
        map.put("code", 100);
        map.put("type", "捕获全局异常");
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        log.info("捕获全局异常 is {} ---{}",map,e);
        return map;
    }

    @ExceptionHandler(value= MyException.class)
    public Object handleException2(MyException e2, HttpServletRequest request2) {
        LOG.error("msg:{},url:{}", e2.getMsg(), request2.getRequestURL());

        Map<String, Object> map = new HashMap<>();
        map.put("code", e2.getCode());
        map.put("type", "捕获自定义异常");
        map.put("getMsg",  e2.getMsg());
        map.put("getMessage",  e2.getMessage());

        map.put("url", request2.getRequestURL());
        log.info("捕获自定义异常 is {}---e is {}",map ,e2);
        return map;
    }
}
