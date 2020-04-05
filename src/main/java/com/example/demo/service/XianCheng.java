package com.example.demo.service;

import com.example.demo.Utils.ReadFromFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/4 22:56
 * @Description:
 */
@Service
@Slf4j
public class XianCheng {

    @Resource(name = "testFxbDrawExecutor")
    ExecutorService service;

    public void test() {
        service.execute(new Runnable() {//没有返回值
            @Override
            public void run() {
//这里就是线程执行的内容
                String name = Thread.currentThread().getName();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("线程池的名字" + name);
            }
        });
    }

    public void test2() {
        Future<?> submit = service.submit(new Callable<Object>() {//submit 有返回值 这个callable
            @Override
            public String call() {
                String name = Thread.currentThread().getName();


                System.out.println("线程池的名字" + name);

                return name;
            }

        });

        try {
            String o = (String) submit.get();
            log.info("fanhui de shi {}", o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


    public void test3(String a) {
        Future<?> submit = service.submit(new Callable<Object>() {
            String name;

            @Override
            public String call() throws Exception {
                for (int i = 0; i < 4; i++) {
                    name = Thread.currentThread().getName();
                    System.out.println("test3--->" + i);
                    System.out.println("test3threadname--->" + name);
                }

                return "test3 ok" + name;
            }
        });

        try {
            Object o = submit.get();
            log.info("fanhui de shi {}", o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    public String test4(String path) throws ExecutionException, InterruptedException {

        String msg;

        Future<Object> submit = service.submit(new Callable<Object>() {
            @Override
            public String call() throws Exception {
                String daxiao = "1";//每个线程 写入1M的内容
                long start = System.currentTimeMillis();
                ReadFromFile.makeZhiDingDaXiaoWenjianadd(path, daxiao);
                long end = System.currentTimeMillis();
                long time = end - start;
                String name = Thread.currentThread().getName();

                return "当前子线程name-->" + name + "--时间-->" + time;
            }
        });


            String o = (String) submit.get();
            log.info("当前线程的返回值--{}", o);
            msg = "当前线程的返回值--{}" + o;


        return msg;
    }

    public String test5(String path) throws ExecutionException, InterruptedException {
        Future<?> submit = service.submit(new Runnable() {
            @Override
            public void run() {
                String daxiao = "1";//每个线程 写入1M的内容
                long start = System.currentTimeMillis();
                ReadFromFile.makeZhiDingDaXiaoWenjianadd(path, daxiao);
                long end = System.currentTimeMillis();
                long time = end - start;
                String name = Thread.currentThread().getName();
                log.info("当前子线程是{} 耗时是{}", name, time);

            }

        });

        String o = (String)submit.get();
        return o ;
    }


    public String test6(String path) throws ExecutionException, InterruptedException {
        Future<Object> submit = service.submit(new Callable<Object>() {

            @Override
            public String call() throws Exception {

                String daxiao = "1";//每个线程 写入1M的内容
                long start = System.currentTimeMillis();
                ReadFromFile.makeZhiDingDaXiaoWenjian(path, daxiao);
                long end = System.currentTimeMillis();
                long time = end - start;
                String name = Thread.currentThread().getName();
                log.info("当前子线程是{} 耗时是{}", name, time);

                return String.valueOf(time);
            }
        });
        String o = (String)submit.get();

        return o ;
    }
}
