package com.example.demo.controller;

import com.example.demo.myException.MyException;
import com.example.demo.service.ExServie;
import com.example.demo.thread.TestRunnable;
import com.example.demo.thread.TestRunnable2;
import com.example.demo.thread.TestRunnable3EX;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/28 22:26
 * @Description:测试自定义异常
 */
@RestController
@Slf4j
public class ExController {

    @Autowired
    private TestRunnable testRunnable;

    @Autowired
    private TestRunnable2 testRunnable2;

    @Autowired
    private ExServie exServie;
    @GetMapping("/ex")//测试多线程
    public String ex(){
        Thread thread = new Thread(testRunnable);
        Thread thread2 = new Thread(testRunnable2);
        thread.start();
        thread2.start();

        for (int a = 0; a < 100; a++) {


            String name = Thread.currentThread().getName();
            System.out.println(" Thread.sleep name is " + name + "a is "+a);

        }
        return "ex";
    }

    //测试在server层抛出自定义类型
    @GetMapping("/ex2")
    public String e2x(){
        exServie.ex();

        return "ex2";
    }

    @Autowired
    TestRunnable3EX testRunnable3EX;

    @GetMapping("/testRunnable3EX")
    public String testRunnable3EX(){
        String name = Thread.currentThread().getName();
        log.info("testRunnable3EX thread is {}",name);
        Thread thread = new Thread(testRunnable3EX);

        thread.run();

        return "testRunnable3EX";
    }

    @GetMapping("/ex3")
    public String ex3(){

        int a = 1/0;
        return "ex3";
    }

    @GetMapping("/ex4")
    public String ex4(){

        throw new MyException("ex4yichang","ex4异常");

    }

    @GetMapping("/ex5")//这里也看出自定义异常类,关于构造函数的
    public String ex5(){//测试 getmessage()方法 会在异常栈打出时显示异常信息.

        throw new MyException("ex5异常");

    }
}
