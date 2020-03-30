package com.example.demo.thread;

import com.example.demo.myException.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 0:00
 * @Description:
 */
@Component
@Slf4j
public class TestRunnable3EX implements Runnable{

    @Override
    public void run() {
        for (int a=0;a<10;a++) {
            String name = Thread.currentThread().getName();
            log.info("TestRunnable3EX1 a = {},name is {}",a,name);
            if(a==5){
            throw new MyException("TestRunnable3EX",name);
            }
            log.info("TestRunnable3EX2 a = {}",a);

        }
    }
}
