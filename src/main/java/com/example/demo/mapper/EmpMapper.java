package com.example.demo.mapper;

import com.example.demo.bean.Emp;
import com.example.demo.bean.EmpQueryFrom;

import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    List<Emp> queryEmp();

    List<Emp> queryEmpByPage(EmpQueryFrom empQueryFrom);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    Integer countEmp();

    Emp selectTest(String a,String b);
}