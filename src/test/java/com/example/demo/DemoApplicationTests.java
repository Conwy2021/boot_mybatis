package com.example.demo;

import com.example.demo.bean.Emp;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.Implements.ServiceImplements;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {


    @Resource
    private EmpMapper empMapper;

    @Test
    public void test2(){

        List<Emp> emps = empMapper.queryEmp();
        System.out.println(emps);
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


}
