package com.example.demo.thread;

import org.springframework.stereotype.Component;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 0:00
 * @Description:
 */
@Component
public class TestRunnable implements Runnable{

    @Override
    public void run() {
       for(int a=0;a<10;a++){
           String name = Thread.currentThread().getName();
           System.out.println("runnable name is "+name+"and a is "+a);

       }
    }
}
