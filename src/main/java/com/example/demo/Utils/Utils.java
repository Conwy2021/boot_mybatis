package com.example.demo.Utils;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @Author: LiuKangwei
 * @Description:
 * @Date: Create in  21:26
 * @Modified By:
 */
public class Utils {

    public static void main(String[] args) {
        
    

    }
    /**
     * @Author:LiuKangwei
     * @param name 
     * @param age
     * @Return:java.lang.String
     * @Date:2019/8/19 22:41
     * @Description:
     */
    public static String say(String name,String age){
        return "hello"+name+age;
    }
    
    /**
     * @Author:LiuKangwei
     * @Return:void
     * @Date:2019/8/19 22:50
     * @Description:
     */
    public static void say(){
        System.out.println("hello");
    }
}
