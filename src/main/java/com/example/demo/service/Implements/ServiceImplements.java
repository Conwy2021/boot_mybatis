package com.example.demo.service.Implements;

import com.example.demo.bean.TDataSchoolIncondition;
import com.example.demo.mapper.TDataSchoolInconditionMapper;
import com.example.demo.service.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:16
 * @Description:
 */

@Service
public class ServiceImplements implements InterfaceService {

    @Resource
    private TDataSchoolInconditionMapper tDataSchoolInconditionMapper;


    @Override
    public List<TDataSchoolIncondition> queryTDataSchoolIncondition() {
        return tDataSchoolInconditionMapper.queryTDataSchoolIncondition();
    }

    @Override
    public TDataSchoolIncondition selectById(String id) {
        return tDataSchoolInconditionMapper.selectByPrimaryKey(id);
    }
}
