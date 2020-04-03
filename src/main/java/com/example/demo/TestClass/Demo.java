package com.example.demo.TestClass;

import com.example.demo.Static.Num;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 14:39
 * @Description:
 */
public class Demo {
    public static void hellodemo(){
        System.out.println("com.example.demo.TestClass.Demo.hello");
    }

    public static void main(String[] args) {
        Integer a = 0;
        System.out.println(a==null);
        new Num();
    }
}
