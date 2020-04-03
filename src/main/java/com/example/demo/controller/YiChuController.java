package com.example.demo.controller;

import com.example.demo.Static.Num;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/1 0:09
 * @Description:
 */
@RestController
public class YiChuController {

    @GetMapping("/StackOverflowError")
    public String StackOverflowError() {
        haha();

        return "StackOverflowError";
    }

    private void haha() {
        StackOverflowError();
    }

    @GetMapping("/OutOfMemoryError")
    public String OutOfMemoryError() {
        //newThread();

        ArrayList list=new ArrayList();

        while(true)

        {

            list.add(new Num());
            System.out.println(list.size());
        }

    }


    public static int count = 1;

    public void noStop() {

        while (true) {

        }

    }


    public void newThread() {

        while (true) {

            Thread t = new Thread(new Runnable() {


                public void run() {
                    new Num();
                    ArrayList list=new ArrayList();
                    System.out.println("已创建第" + count++ + "个线程");
                    while(true)

                    {

                        list.add(new Num());
                        System.out.println(list.size());
                    }




                }


            });

            t.start();


        }


    }

    public static void main(String[] args) {
        ArrayList list=new ArrayList();

        while(true)

        {

            list.add(new Num());
            System.out.println(list.size());
        }
    }
}
