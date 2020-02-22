package com.example.test_10.controller;

import com.example.test_10.bean.ReplyDetail;
import com.example.test_10.mapper.ReplyDetailMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:LiuKangwei
 * @Date:2019/11/2 23:38
 * @Description:
 */
@RestController
@Slf4j
public class ReplyDetailController {

    @Autowired
    private ReplyDetailMapper replyDetailMapper;

    /**
     *根据帖子id展示答复列表
     */
    @GetMapping("/queryReplyDetailList")
    public List<ReplyDetail> queryReplyDetailList(Integer invid) {

        List<ReplyDetail> replyDetails = replyDetailMapper.queryReplyDetailByInvid(invid);
        return replyDetails;
    }

    /**
     *添加回复内容
     */
    @PostMapping("addReplyDetailList")
    @Transactional
    public Map<String, Object> addReplyDetailList(ReplyDetail replyDetail) {
        log.info("回复添加内容为:{}",replyDetail);
        String author = replyDetail.getAuthor();
        if(StringUtils.isEmpty(author)){
            replyDetail.setAuthor("匿名用户");
        }
        replyDetail.setCreatedate(new Date());
        int isSuccess = replyDetailMapper.insert(replyDetail);
        Map<String, Object> map = new HashMap<>();
        if (isSuccess == 0) {
            map.put("message","添加失败");
            return map;
        }
        map.put("message","添加成功");
        return map;
    }

    public static void main(String[] args) {
        String a="2";
        int i = System.identityHashCode(a);
        System.out.println("i"+i);
        a="3";
        int ii = System.identityHashCode(a);
        System.out.println("ii"+ii);
        test(a);
        System.out.println(a);


    }
    static void test(String a){
        int i = System.identityHashCode(a);
        System.out.println(i);
        a="1";
        System.out.println(a);
    }

}
