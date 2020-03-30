package com.example.demo.service;

import com.example.demo.myException.MyException;
import org.springframework.stereotype.Service;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 23:13
 * @Description:
 */
@Service
public class ExServie {

    public void ex(){

        throw new MyException("serviceEx","ex");
    }
}
