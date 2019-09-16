package com.example.demo.controller;

import com.example.demo.bean.Emp;
import com.example.demo.service.Implements.ServiceImplements;
import com.example.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ServiceImplements serviceImplements;

    @GetMapping("/queryEmp")
    public List<Emp> queryEmpContr(){
        return interfaceService.queryEmpServ();
    }

    public List<Emp> queryEmp2(){
        return null;
    }

}
