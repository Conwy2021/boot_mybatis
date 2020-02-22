package com.example.test_10.service;

import com.example.test_10.bean.Invitation;
import com.example.test_10.bean.QueryPage;
import com.github.pagehelper.PageInfo;

/**
 * @Author:LiuKangwei
 * @Date:2019/11/2 20:58
 * @Description:
 */
public interface IInvitationService {

    PageInfo<Invitation> queryInvitationListByPage(String keyword, QueryPage queryPage);
}
