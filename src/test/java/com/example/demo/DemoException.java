package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/11 23:06
 * @Description:
 */
@Slf4j
public class DemoException {
    public static void main(String[] args) {
        try {
            throw new Exception("hello exception");
        } catch (Exception e) {
            System.out.println("catch exception");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println("--------");
            e.printStackTrace();//报错没有打进日志中，没有时间，所以这种方式不好。一般会用异常封装类来封装异常到日志中。
        }
    }


    @Test
    public void de() {
        String i = "abcd";

        byte[] bytes = i.getBytes();//字符转字节
//[97, 98, 99, 100]
        System.out.println(Arrays.toString(bytes));

    }


    @Test
    public void de2() throws UnsupportedEncodingException {
        byte[] bytes = {97, 98, 99, 100};

        String s = new String(bytes, "utf-8");//字节转字符

        System.out.println(s);

    }

    @Test
    public void ok() {//todo 待研究

        char a = 'a';
        ByteBuffer heapByteBuffer = ByteBuffer.allocate(16);
        ByteBuffer byteBuffer = heapByteBuffer.putChar(a);
        byte b = byteBuffer.get(0);
        for(int i=0;i<16;i++){
            char aChar = byteBuffer.getChar(i);
            System.out.println(aChar);

        }


        System.out.println(byteBuffer);
        System.out.println(b);



    }
}
