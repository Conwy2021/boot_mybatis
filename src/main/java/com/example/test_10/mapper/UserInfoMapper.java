package com.example.test_10.mapper;

import com.example.test_10.bean.UserInfo;
import com.example.test_10.model.QueryUserInfoModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<QueryUserInfoModel> queryUserInfoListByPage(String name);
}