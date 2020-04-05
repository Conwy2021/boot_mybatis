package com.example.demo.service.Implements;

import com.example.demo.bean.Emp;
import com.example.demo.bean.OneToManyInsertFrom;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.InterfaceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:16
 * @Description:
 */

@Service
public class ServiceImplements implements InterfaceService {

    Logger logger = LoggerFactory.getLogger(ServiceImplements.class);
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> queryEmpServ() {
        return empMapper.queryEmp();
    }

    // TODO: 2019/9/16
// FIXME: 2019/9/16 
    private List<Emp> queryEmp2() {
        return empMapper.queryEmp();
    }

    @Override
    public String oneToManyInsertFromServ(OneToManyInsertFrom oneToManyInsertFrom) {

        System.out.println(oneToManyInsertFrom);

        String a = "test";
        String b = "test2";
        logger.info("test{},test2{}",a,b);

        return "ok";
    }
}
