package com.example.test_10.controller;

import com.example.test_10.service.iml.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/23 21:40
 * @Description:
 */
@RestController
public class UserLoginController {

    @Autowired
    private LoginServiceImp loginServiceImp;

    @PostMapping("login")
    public String login(String name,String password){
        String message  = loginServiceImp.login(name, password);
        return message;
    }

    @PostMapping("addUser")
    public String userAdd(String name,String password,String yespassword,String sex){
        String message = loginServiceImp.addUser(name, password, yespassword, sex);
        return message;
    }

    @GetMapping("exTest")
    public void exTest(){
        int i = 1/0;
    }
}
