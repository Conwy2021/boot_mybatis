package com.example.demo.mapper;

import com.example.demo.bean.TDataSchoolInfo;
import com.example.demo.bean.TDataSchoolInfoWithBLOBs;

public interface TDataSchoolInfoMapper {
    int deleteByPrimaryKey(String fid);

    int insert(TDataSchoolInfoWithBLOBs record);

    int insertSelective(TDataSchoolInfoWithBLOBs record);

    TDataSchoolInfoWithBLOBs selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(TDataSchoolInfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TDataSchoolInfoWithBLOBs record);

    int updateByPrimaryKey(TDataSchoolInfo record);
}