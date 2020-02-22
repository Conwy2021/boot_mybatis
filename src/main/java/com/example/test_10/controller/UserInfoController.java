package com.example.test_10.controller;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.model.QueryUserInfoModel;
import com.example.test_10.service.IUserInfoService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/25 15:58
 * @Description:
 */
@RestController
@Slf4j
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @GetMapping("/userInfo")
    public PageInfo<QueryUserInfoModel> queryUserInfoByPage(String name, QueryPage queryPage) throws Exception{
        try {
            PageInfo<QueryUserInfoModel> queryUserInfoModelPageInfo = iUserInfoService.queryUserInfoByPage(name, queryPage);
            return  queryUserInfoModelPageInfo;
        }catch (Exception e){
            e.printStackTrace();
            log.warn("异常消息{}",e);
            throw new Exception("服务器异常",e);
        }


    }
}
