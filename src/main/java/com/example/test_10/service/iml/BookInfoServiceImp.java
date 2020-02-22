package com.example.test_10.service.iml;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.form.QueryBookInfoForm;
import com.example.test_10.mapper.BookInfoMapper;
import com.example.test_10.model.QueryBookInfoModel;
import com.example.test_10.service.IBookInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/23 0:56
 * @Description:
 */
@Service
@Slf4j
public class BookInfoServiceImp implements IBookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public PageInfo<QueryBookInfoModel> queryBookInfoListBypage(QueryBookInfoForm form, QueryPage page) {
        log.info("from-->{},page-->{}",form,page);

        PageHelper.startPage(page.getPage(),page.getLimit());
        List<QueryBookInfoModel> queryBookInfoModels = bookInfoMapper.queryBookInfoList(form);
        PageInfo<QueryBookInfoModel> queryBookInfoModelPageInfo = new PageInfo<>(queryBookInfoModels);
        return queryBookInfoModelPageInfo;
    }
}
