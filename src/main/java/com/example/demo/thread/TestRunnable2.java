package com.example.demo.thread;

import org.springframework.stereotype.Component;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 0:00
 * @Description:
 */
@Component
public class TestRunnable2 implements Runnable{

    @Override
    public void run() {
       for(int a=0;a<10;a++){
           String name = Thread.currentThread().getName();
           System.out.println("runnable2 name is "+name+"and a is "+a);

       }
    }
}
/*
for 循环等同于
int a=0;
while(a<10){
        String name = Thread.currentThread().getName();
        System.out.println("runnable2 name is "+name+"and a is "+a);
        a++;
        }*/
