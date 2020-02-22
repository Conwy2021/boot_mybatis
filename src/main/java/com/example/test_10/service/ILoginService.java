package com.example.test_10.service;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/23 21:43
 * @Description:
 */
public interface ILoginService {

    String login(String name,String password);

    String addUser(String name,String password,String yespassword,String sex);
}
