package com.example.demo.controller;

import com.example.demo.bean.Emp;
import com.example.demo.bean.OneToManyInsertFrom;
import com.example.demo.service.Implements.ServiceImplements;
import com.example.demo.service.InterfaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.OperationsException;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:32
 * @Description:
 */
@RestController
@Slf4j
public class Controller {

    @Autowired
    private InterfaceService interfaceService;

    @Autowired
    private ServiceImplements serviceImplements;

    @GetMapping("/queryEmp")
    public List<Emp> queryEmpContr(){
        log.debug("queryEmpContr-->{}",interfaceService.queryEmpServ());
        return interfaceService.queryEmpServ();
    }

    public List<Emp> queryEmp2(){
        return null;
    }

    @PostMapping("/insertOneToMany")
    public String insertOneToManyContr(@RequestBody OneToManyInsertFrom oneToManyInsertFrom){

        String s = interfaceService.oneToManyInsertFromServ(oneToManyInsertFrom);

        return s;
    }

}
