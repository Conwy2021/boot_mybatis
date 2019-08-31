package com.example.demo.controller;

import com.example.demo.bean.TDataSchoolIncondition;
import com.example.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/querySchoolIncondition",method = RequestMethod.GET)
    public List<TDataSchoolIncondition> querySchoolIncondition(){
        return interfaceService.queryTDataSchoolIncondition();
    }
}
