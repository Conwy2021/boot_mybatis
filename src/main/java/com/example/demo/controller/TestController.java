package com.example.demo.controller;


import com.example.demo.Static.Num;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
