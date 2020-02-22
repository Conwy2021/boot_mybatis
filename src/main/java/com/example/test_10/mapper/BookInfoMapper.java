package com.example.test_10.mapper;

import com.example.test_10.bean.BookInfo;
import com.example.test_10.form.QueryBookInfoForm;
import com.example.test_10.model.QueryBookInfoModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BookInfoMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);

    List<QueryBookInfoModel> queryBookInfoList(QueryBookInfoForm form);
}