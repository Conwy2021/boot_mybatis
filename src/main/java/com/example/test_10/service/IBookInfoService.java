package com.example.test_10.service;

import com.example.test_10.bean.QueryPage;
import com.example.test_10.form.QueryBookInfoForm;
import com.example.test_10.model.QueryBookInfoModel;
import com.github.pagehelper.PageInfo;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/23 0:55
 * @Description:
 */
public interface IBookInfoService {
    PageInfo<QueryBookInfoModel> queryBookInfoListBypage(QueryBookInfoForm form, QueryPage page);
}
