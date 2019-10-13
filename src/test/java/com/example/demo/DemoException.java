package com.example.demo;

import ch.qos.logback.core.net.SyslogOutputStream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/11 23:06
 * @Description:
 */
@Slf4j
public class DemoException {
    public static void main(String[] args) {
       try {
           throw new Exception("hello exception");
       }catch (Exception e){
           System.out.println("catch exception");
           System.out.println(e.getMessage());
           System.out.println(e.toString());
           System.out.println("--------");
           e.printStackTrace();//报错没有打进日志中，没有时间，所以这种方式不好。一般会用异常封装类来封装异常到日志中。
       }
    }



}
