import com.example.DemoApplication;
import com.example.demo.Enum.DemoEnum;
import com.example.demo.Enum.YNEnum;
import com.example.demo.Static.Num;
import com.example.demo.bean.Emp;
import com.example.demo.bean.EmpQueryFrom;
import com.example.demo.controller.Controller;
import com.example.demo.mapper.EmpMapper;
import com.example.test_10.bean.Users;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@Slf4j
public class DemoApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate; //在MyRedisConfig文件中配置了redisTemplate的序列化之后， 客户端也能正确显示键值对了

    @Resource
    private EmpMapper empMapper;

    @Resource
    private Controller controller;

    /**
     *redis测试
     */
    @Test
    public void testRedis(){
        //存值
        redisTemplate.opsForValue().set("9527", "周星驰",10, TimeUnit.SECONDS);
        //是否有值
        Boolean isExist = redisTemplate.hasKey("9527");
        System.out.println("是否存在key=9527..."+isExist);
        //取值
        System.out.println(redisTemplate.opsForValue().get("9527"));
        Map<String, Object> map = new HashMap<>();
        for (int i=0; i<10; i++){
            Users Users = new Users();
            Users.setUserId(i);
            Users.setUserCode(String.format("测试%d", i));
            Users.setEmail(String.valueOf(i));
            Users.setPassword(String.valueOf(i));
            Users.setGender("1");
            Users.setLastLogintime(new Date());
            Users.setRegisterTime(new Date());
            map.put(String.valueOf(i),Users);
        }
        redisTemplate.opsForHash().putAll("测试", map);
        BoundHashOperations hashOps = redisTemplate.boundHashOps("测试");
        Map map1 = hashOps.entries();
        System.out.println(map1);
    }
    
    
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
        String[] split = StringUtils.split(s, "|");
        System.out.println(split);
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

    @Test
    public void test249(){
        int a=2;
        int b=a;
        a=3;
        System.out.println(a);

        String c = "kk";
        //String d=c;
        System.out.println(c.hashCode()); //改变的是引用 实际对象是没有改变的 使用final 和private修饰  一般看到变化都是因为新增了一个对象改变了引用 特例是反射
        c="kk";
        System.out.println(c.hashCode());
        System.out.println(c);

    }

}
