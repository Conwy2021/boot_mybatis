package com.example.test_10.mapper;

import com.example.test_10.bean.BookType;
import com.example.test_10.model.BookTypeModel;

import java.util.List;


public interface BookTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookType record);

    int insertSelective(BookType record);

    BookType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookType record);

    int updateByPrimaryKey(BookType record);

    List<BookTypeModel> queryBookTypeList();
}