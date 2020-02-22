package com.example.test_10.controller;

import com.example.test_10.model.BookTypeModel;
import com.example.test_10.service.IBookTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 20:40
 * @Description:
 */
@RestController
@Slf4j
public class BookTypeController {

    @Autowired
    private IBookTypeService iBookTypeService;

    @GetMapping("/bookTypeList")
    public List<BookTypeModel> queryBookList(){
        List<BookTypeModel> bookTypeModels = iBookTypeService.queryBookTypeList();
        log.info("类型清单是{}",bookTypeModels);
        return bookTypeModels;
    }

}
