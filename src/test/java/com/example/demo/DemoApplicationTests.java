package com.example.demo;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import com.example.demo.Enum.DemoEnum;
import com.example.demo.Enum.YNEnum;
import com.example.demo.Static.Num;
import com.example.demo.bean.Emp;
import com.example.demo.bean.EmpQueryFrom;
import com.example.demo.controller.Controller;
import com.example.demo.mapper.EmpMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.lang.model.element.NestingKind;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {


    @Resource
    private EmpMapper empMapper;

    @Resource
    private Controller controller;

    /**
     * @Author:LiuKangwei
     * @Return:void
     * @Date:2019/9/23 0:16
     * @Description: 模板
     */
    @Test
    public void testDemo() {

    }

    @Test
    public void testDemo7() {
        String s = new String("a|a");
        StringUtils.split(s,"|");
        System.out.println(s);
    }

    @Test
    public void testDemo6() {

        Date date = new Date();
        System.out.println(date);

    }

    @Test
    public void testDemo5() {

        List<Emp> emps = controller.queryEmpContr();
        log.info("log info {}", emps);
        System.out.println("sout--->" + emps);
    }

    @Test
    public void testDemo4() {
        Emp emp = empMapper.selectTest("经理", "10001");
        System.out.println(emp);
    }


    @Test
    public void testDemo3() {
        DemoEnum chun = DemoEnum.chun;
        System.out.println(chun);

    }

    @Test
    public void testDemo2() {

        YNEnum yes = YNEnum.YES;
        System.out.println(yes);
        int name = yes.getName();
        System.out.println(yes.getName());
    }

    @Test
    public void testDemo1() {

        int num = Num.number;
        Num.number++;
//        num++;错误  不会自增
//        num=num+1;错误  不会自增
        String s = String.valueOf(num);
        System.out.println(s);
    }

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
    public void test4() {
        List c = new ArrayList<>();
        StringBuilder builder = new StringBuilder("leaves growing");
        do {
            builder.delete(0, 5);
        } while (builder.length() > 5);
        System.out.println(builder);

    }

    public static void main(String... books) {
        StringBuilder sb = new StringBuilder();
        for (String book : books) {
            sb.insert(sb.indexOf("c"), book);
            System.out.println(sb);
        }
    }

    @Test
    public void test5() {
        main("car", "carts");//下标越界
    }

    @Test
    public void test6() {
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


    /**
     * @Author:LiuKangwei
     * @Return:void
     * @Date:2019/9/22 18:14
     * @Description:分页测试，条件查询测试
     */
    @Test
    public void test8() {
        EmpQueryFrom empQueryFrom = new EmpQueryFrom();
        empQueryFrom.setCurrPage(2);
        empQueryFrom.setPageSize(1);
        List<Emp> emps = empMapper.queryEmpByPage(empQueryFrom);
        System.out.println(emps);

        EmpQueryFrom empQueryFrom1 = new EmpQueryFrom();
        empQueryFrom1.setKeyword("哈");
        empQueryFrom.setCurrPage(2);
        empQueryFrom.setPageSize(1);
        List<Emp> emps1 = empMapper.queryEmpByPage(empQueryFrom1);
        System.out.println("关键字" + emps1);
    }
}
