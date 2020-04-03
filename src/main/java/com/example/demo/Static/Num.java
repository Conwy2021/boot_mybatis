package com.example.demo.Static;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/22 23:24
 * @Description:
 */
public class Num {
    public static int number = 0;

    public Num() {
        System.out.println();
        hello2();
    }

    int a;
    public static void hello(){

        System.out.println("com.example.demo.Static.Num");
    }

    static {
        hello();

        System.out.println("11111");
    }

    public  void hello2(){
        System.out.println(a);
        System.out.println("com.example.demo.Static.Num");
    }
}
