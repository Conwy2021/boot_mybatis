package com.example.test_10.service;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.model.QueryUserInfoModel;
import com.github.pagehelper.PageInfo;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/25 15:47
 * @Description:
 */
public interface IUserInfoService {

    PageInfo<QueryUserInfoModel> queryUserInfoByPage(String name, QueryPage queryPage);
}
