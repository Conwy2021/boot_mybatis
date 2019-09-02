package com.example.demo.mapper;

import com.example.demo.bean.Emp;

import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    List<Emp> queryEmp();

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
}