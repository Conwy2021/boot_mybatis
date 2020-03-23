package com.example.demo.controller;


import com.example.demo.Static.Num;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {
//http://localhost:8009/springBoot/hello
    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String test() {
        String debug = "debug";
        String warn = "warn";
        String info = "info";
        String error = "error";
        log.debug("my name is {}",debug);
        log.warn("my name is {}",warn);
        log.info("my name is {}",info);
        log.error("my name is {}",error);

        int num = Num.number;
        Num.number++;
//        num++;错误  不会自增 常量池中的加了一；
//        num=num+1;
        String s = String.valueOf(num);

        return "number-----"+s;
    }

    /**
     * @Author:LiuKangwei
     * @param request
     * @param response
     * @Return:java.util.Map<java.lang.String,java.lang.Object>
     * @Date:2019/10/15 23:54
     * @Description:request.getRequestURL().toString:获取请求的URL
     * request.getParameter(" 键 "):获取表单提交的参数
     * request.getMethod():获取请求方式
     * getCookies():获得cookie信息
     * getScheme():获取协议
     * getServerName() 获取主机名
     * getServerPort() 获取服务器的端口
     * getContextPath() 获取上下文路径
     * getServletPath() 获取路径中除上下文后的其他路径
     * getRequesURI() 获取请求的完整路径
     *
     * 获取请求头的信息:
     *     统一是getHeader方法，方法中传入请求头的名字
     *     如：request.getHeader("Accept-Language")
     *
     * 重点：获取上下文路径: request.getContextPath
     */
    @GetMapping(value = "/get")
    public Map<String,Object> get(HttpServletRequest request, HttpServletResponse response){

        Map<String, Object> map = new HashMap<>();
        String uri = request.getRequestURI();
        map.put("uri",uri);
        StringBuffer requestURL = request.getRequestURL();
        map.put("url",requestURL.toString());
        String parameter = request.getParameter("hello");
        map.put("parameter",parameter);
        String method = request.getMethod();
        map.put("method", method);
        Cookie[] cookies = request.getCookies();
        map.put("cookies",cookies);
        String contextPath = request.getContextPath();
        map.put("contextPath",contextPath);
        String header = request.getHeader("Accept-Language");
        map.put("header",header);
        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(200);

        return map;

    }

    @GetMapping(value = "/getTest")
    public Map<String,Object> getTest(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("1","1");

        return map;
    }

    @PostMapping(value ="/rizhi")
    public void rizhi(@RequestBody String a){

        log.info("a is {}",a);
    }
    @GetMapping (value ="/rizhi2")
    public void rizhi2( String a){

        log.info("a is {}",a);
    }

    @PutMapping(value ="/rizhi3")
    public void rizhi3(@RequestBody String a){

        log.info("a is {}",a);
    }
}
