package com.example.test_10.service.iml;

import com.example.test_10.model.BookTypeModel;
import com.example.test_10.mapper.BookTypeMapper;
import com.example.test_10.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 20:43
 * @Description:
 */
@Service
public class BookTypeServiceImp implements IBookTypeService {

    @Autowired
    private BookTypeMapper bookTypeMapper;

    @Override
    public List<BookTypeModel> queryBookTypeList() {
        List<BookTypeModel> bookTypeModels = bookTypeMapper.queryBookTypeList();
        return bookTypeModels;
    }
}
