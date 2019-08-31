package com.example.demo.service;

import com.example.demo.bean.TDataSchoolIncondition;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/8/20 22:07
 * @Description:
 */


public interface InterfaceService {

    List<TDataSchoolIncondition> queryTDataSchoolIncondition();

    TDataSchoolIncondition selectById(String id);
}
