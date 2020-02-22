package com.example.test_10.controller;

import com.example.test_10.bean.Invitation;
import com.example.test_10.bean.QueryPage;
import com.example.test_10.mapper.InvitationMapper;
import com.example.test_10.mapper.ReplyDetailMapper;
import com.example.test_10.service.iml.InvitationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @Author:LiuKangwei
 * @Date:2019/11/2 21:45
 * @Description:
 */
@RestController
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private ReplyDetailMapper replyDetailMapper;

    @Autowired
    private InvitationMapper invitationMapper;

    /**
     * 帖子列表展示页面
     */
    @GetMapping("/queryInvitations")
    public PageInfo<Invitation> queryInvicationListByPage(String keyword, QueryPage queryPage) {
        PageInfo<Invitation> invitationPageInfo = invitationService.queryInvitationListByPage(keyword, queryPage);
        return invitationPageInfo;
    }

    /**
     * 帖子删除api
     */
    @PostMapping("deleteById")
    @Transactional
    public String deleteById(Integer id) {
        int i1 = invitationMapper.deleteByPrimaryKey(id);
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(id);
        int i = replyDetailMapper.deleteByInvidList(integers);
        if (i1 == 0 || i == 0) {
            throw new RuntimeException("删除失败");

        }
        return "删除成功";
    }

}
