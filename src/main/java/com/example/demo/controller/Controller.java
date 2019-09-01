package com.example.demo.controller;

import com.example.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:32
 * @Description:
 */
@RestController
public class Controller {

    @Autowired
    private InterfaceService interfaceService;


}
