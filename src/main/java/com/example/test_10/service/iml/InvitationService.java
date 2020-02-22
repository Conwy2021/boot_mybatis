package com.example.test_10.service.iml;

import com.example.test_10.bean.Invitation;
import com.example.test_10.bean.QueryPage;
import com.example.test_10.mapper.InvitationMapper;
import com.example.test_10.service.IInvitationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/11/2 21:03
 * @Description:
 */
@Service
public class InvitationService implements IInvitationService {

    @Autowired
    private InvitationMapper invitationMapper;

    @Override
    public PageInfo<Invitation> queryInvitationListByPage(String keyword, QueryPage queryPage) {
        PageHelper.startPage(queryPage.getPage(),queryPage.getLimit());
        List<Invitation> invitations = invitationMapper.queryListInvitation(keyword);
        PageInfo<Invitation> invitationsPageInfoList = new PageInfo<>(invitations);

        return invitationsPageInfoList;
    }
}
