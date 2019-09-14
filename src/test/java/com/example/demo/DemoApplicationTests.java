package com.example.demo;

import com.example.demo.bean.Emp;
import com.example.demo.mapper.EmpMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {


    @Resource
    private EmpMapper empMapper;

    @Test
    public void test2() {

        List<Emp> emps = empMapper.queryEmp();
        System.out.println(emps);

        Collections.sort(emps, ((o1, o2) -> {
            int len1 = o1.getMgr();
            int len2 = o2.getMgr();
            return len2 - len1;
        }));
        System.out.println(emps);
    }

    @Test
    public void test3() {
        List<Emp> emps = empMapper.queryEmp();
        Map<Integer, String> empNameMap = emps.stream().collect(Collectors.toMap(Emp::getEmpno, Emp::getEname));
        System.out.println(empNameMap);
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
    public void test4(){
        List c = new ArrayList<>();
        StringBuilder builder = new StringBuilder("leaves growing");
        do{
            builder.delete(0,5);
        }while(builder.length()>5);
        System.out.println(builder);

    }

    public static void main(String...books) {
        StringBuilder sb = new StringBuilder();
        for (String book : books) {
            sb.insert(sb.indexOf("c"),book);
            System.out.println(sb);
        }
    }

    @Test
    public void test5() {
        main("car","carts");//下标越界
    }

    @Test
    public void test6(){
        HashSet<String> strings = new HashSet<>();
        strings.add("a");
        strings.add("a");
        strings.add("b");
        strings.add("b");
        strings.add("c");
        strings.add("c");
        ArrayList<String> lists = new ArrayList<>(strings);
        System.out.println(lists);
    }

    @Test
    public void test7() {
       /* Emp emp = empMapper.selectByPrimaryKey(10001);
        System.out.println(emp);*/

        Integer integer = empMapper.countEmp();
        System.out.println(integer);
    }
}
