package com.example.test_10.controller;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.form.QueryBookInfoForm;
import com.example.test_10.model.QueryBookInfoModel;
import com.example.test_10.service.iml.BookInfoServiceImp;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 23:52
 * @Description:
 */
@RestController
@Slf4j
public class BookInfoController {

    @Autowired
    private BookInfoServiceImp bookInfoServiceImp;

    @GetMapping("/bookInfoList")
    public PageInfo<QueryBookInfoModel> queryBookInfoModelListBypage(QueryBookInfoForm queryBookInfoForm, QueryPage page){
        return bookInfoServiceImp.queryBookInfoListBypage(queryBookInfoForm,page);
    }
}
