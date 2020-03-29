package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/28 22:26
 * @Description:
 */
@RestController
public class ExController {

    @GetMapping("/ex")
    public String ex(){

        try {
            Thread.sleep(Long.parseLong("1000"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return "";
    }
}
