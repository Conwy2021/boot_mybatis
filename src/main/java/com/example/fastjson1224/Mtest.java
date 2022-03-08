package com.example.fastjson1224;

import com.example.bean.User;

import java.io.*;

/**
 * @Author:LiuKangwei
 * @Date:2022/3/5 21:41
 * @Description:
 */
public class Mtest {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setAge(99);
        user.setName("security");
        FileOutputStream stream = new FileOutputStream(new File("E:\\fanxulihua\\user.ser"));
        ObjectOutputStream outputStream = new ObjectOutputStream(stream);
        outputStream.writeObject(user);
        outputStream.close();

    }

}
