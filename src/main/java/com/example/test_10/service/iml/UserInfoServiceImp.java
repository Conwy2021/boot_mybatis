package com.example.test_10.service.iml;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.mapper.UserInfoMapper;
import com.example.test_10.model.QueryUserInfoModel;
import com.example.test_10.service.IUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/25 15:47
 * @Description:
 */
@Service
public class UserInfoServiceImp implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageInfo<QueryUserInfoModel> queryUserInfoByPage(String name, QueryPage queryPage) {
        PageHelper.startPage(queryPage.getPage(),queryPage.getLimit());
        List<QueryUserInfoModel> queryUserInfoModels = userInfoMapper.queryUserInfoListByPage(name);
        PageInfo<QueryUserInfoModel> queryUserInfoModelPageInfo = new PageInfo<QueryUserInfoModel>(queryUserInfoModels);

        return queryUserInfoModelPageInfo;
    }
}
