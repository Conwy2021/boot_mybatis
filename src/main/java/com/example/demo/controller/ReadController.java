package com.example.demo.controller;

import com.example.demo.Utils.ReadFromFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/6 0:00
 * @Description:
 */
@RestController
@Slf4j
public class ReadController {

    @GetMapping("/read")
    public String read(String path){

        String readwenjian = ReadFromFile.readwenjian(path);



        return readwenjian;
    }


    @GetMapping("/read2")
    public String read2(String path) throws IOException {

        String readwenjian = ReadFromFile.readwenjian2(path);



        return readwenjian;
    }

    @GetMapping("/read3")
    public String read3(String path) throws IOException {

        String readwenjian = ReadFromFile.readwenjian3(path);



        return readwenjian;
    }

    @GetMapping("/read4")
    public String read4() throws IOException {


        File file = new File("D:/youarebest/newTemp4.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String s = bufferedReader.readLine();
        System.out.println(s);

        return s ;
    }
}

