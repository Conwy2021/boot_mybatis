package com.example.demo;

import com.example.demo.bean.TDataSchoolIncondition;
import com.example.demo.mapper.TDataSchoolInconditionMapper;
import com.example.demo.mapper.TDataSchoolMapper;
import com.example.demo.service.Implements.ServiceImplements;
import com.example.demo.service.InterfaceService;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {

    @Resource
    TDataSchoolInconditionMapper tDataSchoolInconditionMapper;

    @Resource
    ServiceImplements serviceImplements;

    @Test
    public void contextLoads() {

        List<TDataSchoolIncondition> tDataSchoolInconditions = tDataSchoolInconditionMapper.queryTDataSchoolIncondition();
        System.out.println(tDataSchoolInconditions);
    }


    @Test
    public void test() {
        String name = "hello world";
        log.debug("my name is {}", name);
        System.out.println(name);

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.forEach(e -> System.out.println(e));


    }

    @Test
    public void test2() {
        List<TDataSchoolIncondition> tDataSchoolInconditions = serviceImplements.queryTDataSchoolIncondition();
        System.out.println(tDataSchoolInconditions);
    }
}
