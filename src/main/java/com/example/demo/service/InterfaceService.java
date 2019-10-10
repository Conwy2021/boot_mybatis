package com.example.demo.service;

import com.example.demo.bean.Emp;
import com.example.demo.bean.OneToManyInsertFrom;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:07
 * @Description:
 */


public interface InterfaceService {

    List<Emp> queryEmpServ();

    String oneToManyInsertFromServ(OneToManyInsertFrom oneToManyInsertFrom);
}
