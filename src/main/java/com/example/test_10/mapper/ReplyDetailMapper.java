package com.example.test_10.mapper;

import com.example.test_10.bean.ReplyDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ReplyDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReplyDetail record);

    int insertSelective(ReplyDetail record);

    ReplyDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReplyDetail record);

    int updateByPrimaryKey(ReplyDetail record);

    ///**
    //     * 对应帖子表的主键
    //     */
    //    private Integer invid; 根据invid查询多个回复信息
    List<ReplyDetail> queryReplyDetailByInvid(Integer invid);

    // 批量删除,删除关联的回复id
    int deleteByInvidList(@Param("invidList") List<Integer> invidList);
}