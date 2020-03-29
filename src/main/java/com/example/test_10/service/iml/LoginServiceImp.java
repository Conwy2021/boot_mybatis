package com.example.test_10.service.iml;

import com.example.test_10.bean.Users;
import com.example.test_10.mapper.UsersMapper;
import com.example.test_10.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/23 21:45
 * @Description:
 */
@Service
public class LoginServiceImp implements ILoginService {


    @Autowired
    private UsersMapper usersMapper;

    @Override
    public String login(String name,String password) {
        int exist = usersMapper.isExist(name, password);
        if(exist==0){
           return "账号或者密码错误";
        }
        return "登入成功";
    }

    @Override
    @Transactional
    public String addUser(String name, String password, String yespassword, String sex) {
        if(password.compareTo(yespassword)!=0){
            return "两次密码不一致";
        }
        if(sex.isEmpty()){
            return "请选择性别";
        }
        Users users = new Users();
        users.setUserCode(name);
        users.setEmail("");
        users.setGender(sex);
        users.setPassword(password);
        users.setRegisterTime(new Date());
        users.setLastLogintime(new Date());

        int insert = usersMapper.insert(users);
        System.out.println("insert is "+insert);
        if(insert==0){
            return "注册失败";
        }
        return "注册成功";
    }

    @Override
    public String addUser2(String name, String password, String yespassword, String sex) {

        if(password.compareTo(yespassword)!=0){
            return "两次密码不一致2";
        }
        if(sex.isEmpty()){
            return "请选择性别2";
        }
        Users users = new Users();
        users.setUserCode(name);
        users.setEmail("");
        users.setGender(sex);
        users.setPassword(password);
        users.setRegisterTime(new Date());
        users.setLastLogintime(new Date());

        int insert = usersMapper.insert(users);
        System.out.println("insert2 is "+insert);
        if(insert==0){
            return "注册失败2";
        }
        return "注册成功2";

    }
}
