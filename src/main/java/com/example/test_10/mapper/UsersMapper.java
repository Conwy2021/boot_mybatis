package com.example.test_10.mapper;

import com.example.test_10.bean.Users;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int isExist(String name,String password);
}