package com.example.demo;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/6 0:52
 * @Description:
 */
public class FileReadingTest {

    @Test
    public void tet() throws IOException {
        File file = new File("D:/youarebest/newTemp4.txt");
        FileInputStream in = new FileInputStream(file);
        int read = in.read();//读取下一个字节
        int read1 = in.read();
        int read2 = in.read();
        int read3 = in.read();
        System.out.println(read); System.out.println(read1);
        System.out.println(read2); System.out.println(read3);//一个字节一个读 没有就返回-1

        in.close();
        System.out.println("--------------");
        in=new FileInputStream(file);
        byte[] bytes = new byte[2];
        int read4 = in.read(bytes,0,2);//读到bytes数组中,读一个字节 #这个len是读几个字节 到内存中

        int available = in.available();
        System.out.println("-----"+available);//通道里的字节
        System.out.println(read4);
        System.out.println(Arrays.toString(bytes));
        int read5 = in.read(bytes,0,2);//第二次读的时候读了一个两个

        System.out.println(read5);
        System.out.println(Arrays.toString(bytes));
        int available2 = in.available();
        System.out.println("-----"+available2);
        System.out.println("--------------");


    }
    String path ="D:/youarebest/newTemp4.txt";
    @Test
    public void test2() throws IOException {

        File file = new File("D:/youarebest/newTemp4.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String s = bufferedReader.readLine();
        System.out.println(s);
        String s2 = bufferedReader.readLine();
        System.out.println(s2);
        String s3 = bufferedReader.readLine();
        System.out.println(s3);
        String s4 = bufferedReader.readLine();
        System.out.println(s4);

    }


}
