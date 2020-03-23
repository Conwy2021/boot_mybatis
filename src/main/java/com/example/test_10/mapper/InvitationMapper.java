package com.example.test_10.mapper;

import com.example.test_10.bean.Invitation;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface InvitationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Invitation record);

    int insertSelective(Invitation record);

    Invitation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Invitation record);

    int updateByPrimaryKey(Invitation record);

    List<Invitation> queryListInvitation(String keyword);
}