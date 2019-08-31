package com.example.demo.mapper;

import com.example.demo.bean.TDataSchoolIncondition;


import java.util.List;



public interface TDataSchoolInconditionMapper {
    int deleteByPrimaryKey(String fid);

    int insert(TDataSchoolIncondition record);

    int insertSelective(TDataSchoolIncondition record);

    TDataSchoolIncondition selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(TDataSchoolIncondition record);

    int updateByPrimaryKeyWithBLOBs(TDataSchoolIncondition record);

    int updateByPrimaryKey(TDataSchoolIncondition record);

    List<TDataSchoolIncondition> queryTDataSchoolIncondition();
}