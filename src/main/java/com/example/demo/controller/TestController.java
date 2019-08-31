package com.example.demo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public String test() {
        String name = "tom";
        log.debug("my name is {}",name);
        log.warn("my name is {}",name);
        log.info("my name is {}",name);
        log.error("my name is {}",name);

        return "helloworld222";
    }
}
