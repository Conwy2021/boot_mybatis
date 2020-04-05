package com.example.demo.controller;

import com.example.demo.Utils.ReadFromFile;
import com.example.demo.service.XianCheng;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/4 23:04
 * @Description:
 */
@RestController
@Slf4j
public class XianChengController {
    @Autowired
    XianCheng cheng;


    @GetMapping("/xiancheng")
    public String xiancheng() {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            cheng.test();
        }
        long l1 = System.currentTimeMillis();
        long time = l1-l;

        return "time is "+time;

    }

    @GetMapping("/xiancheng2")
    public void xiancheng2() {
        for (int i = 0; i < 10; i++) {
            cheng.test2();
        }
    }

    @GetMapping("/xiancheng3")
    public void xiancheng3(int a) {
        for (int i = 0; i < a; i++) {
            cheng.test3(String.valueOf(a));
        }
    }


    @GetMapping("/xiancheng4")//有返回值的
    public void xiancheng4(String path, int daxiao) throws ExecutionException, InterruptedException {//文件 大小 单位 M
        ArrayList<String> list = new ArrayList<>();
        File file = new File(path);
        ReadFromFile.clearInfoForFile(file);//先清空文件
        long start = System.currentTimeMillis();
        for (int i = 0; i < daxiao; i++) {
            String s = cheng.test4(path);
            list.add(s);
        }
        long end = System.currentTimeMillis();

        long time = end - start;

        log.info("汇总list is {} ", list);
        log.info("总耗时为--->{}", time);
    }


    @GetMapping("/xiancheng5")//有返回值的
    public String xiancheng5(String path, int daxiao) throws ExecutionException, InterruptedException {//文件 大小 单位 M
        ArrayList<String> list = new ArrayList<>();



        File file = new File(path);
        ReadFromFile.clearInfoForFile(file);//先清空文件
        long start = System.currentTimeMillis();
        String s = cheng.test5(path);
        log.info("返回值是{}",s);

        for (int i = 0; i < 10; i++) {
            cheng.test();
        }


        long end = System.currentTimeMillis();

        long time = end - start;

        log.info("汇总list is {} ", list);
        log.info("总耗时为--->{}", time);

        return "ok";
    }

    @GetMapping("/xiancheng6")
    public String deo(){
        long l = System.currentTimeMillis();
        ReadFromFile.makeZhiDingDaXiaoWenjian("D:/youarebest/newTemp.txt","1");
        ReadFromFile.makeZhiDingDaXiaoWenjian("D:/youarebest/newTemp2.txt","1");
        ReadFromFile.makeZhiDingDaXiaoWenjian("D:/youarebest/newTemp3.txt","1");
        ReadFromFile.makeZhiDingDaXiaoWenjian("D:/youarebest/newTemp4.txt","1");
        long l2 = System.currentTimeMillis();

        log.info("time is {}",l2-l);
        return "ok";

    }

    @GetMapping("/xiancheng7")
    public String he() throws ExecutionException, InterruptedException {


        long l = System.currentTimeMillis();
        cheng.test6("D:/youarebest/newTemp.txt");
        cheng.test6("D:/youarebest/newTemp2.txt");
        cheng.test6("D:/youarebest/newTemp3.txt");
        cheng.test6("D:/youarebest/newTemp4.txt");

        long l2 = System.currentTimeMillis();

        System.out.println(l2- l);



        return "ok";
    }

}
