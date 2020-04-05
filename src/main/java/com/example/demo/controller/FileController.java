package com.example.demo.controller;

import com.example.demo.Utils.ReadFromFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.regex.Pattern;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/3 22:55
 * @Description:创建文件 写入数据 然后读出来 然后返回到前端
 */
@Slf4j
@RestController
public class FileController {

    @GetMapping("makewenjian")
    public String makewenjian(String path) {//C:/temp/newTemp.txt

        File file = new File(path);
        String makewenjian = ReadFromFile.makewenjian(file);


        return makewenjian;

    }

    /**
     * @param path neirong
     * @Author:LiuKangwei
     * @Return:java.lang.String
     * @Date:2020/4/4 19:26
     * @Description:写入文件
     */
    @GetMapping("writewenjian")
    public String writewenjian(String path, String neirong) {

        String writewenjian = ReadFromFile.writewenjian(neirong, path);


        return writewenjian;

    }


    /**
     * @param path
     * @param daxiaoM
     * @Author:LiuKangwei
     * @Return:java.lang.String
     * @Date:2020/4/5 14:17
     * @Description:
     */
    @GetMapping("writewenjian2")
    public String writewenjian2(String path, String daxiaoM) {
        String pattern = "^[1-9]\\d*$";
        boolean isMatch = Pattern.matches(pattern, daxiaoM);
        if (!isMatch) {
            return "daxiaoM 限制正整数";
        }
        long start = System.currentTimeMillis();

        String writewenjian2 = ReadFromFile.makeZhiDingDaXiaoWenjian(path, daxiaoM);

        long end = System.currentTimeMillis();

        long time = end - start;
        log.info("花费时间---->{}",time);
        return writewenjian2;

    }


}
