package com.example.demo.mapper;

import com.example.demo.bean.TDataSchool;
import com.example.demo.bean.TDataSchoolWithBLOBs;

public interface TDataSchoolMapper {
    int deleteByPrimaryKey(String fid);

    int insert(TDataSchoolWithBLOBs record);

    int insertSelective(TDataSchoolWithBLOBs record);

    TDataSchoolWithBLOBs selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(TDataSchoolWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TDataSchoolWithBLOBs record);

    int updateByPrimaryKey(TDataSchool record);
}