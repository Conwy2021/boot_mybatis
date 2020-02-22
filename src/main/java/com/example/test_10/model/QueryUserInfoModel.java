package com.example.test_10.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/25 15:20
 * @Description:
 */
@Data
public class QueryUserInfoModel implements Serializable {


    private static final long serialVersionUID = 7697709057641883303L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名;长度6位（含）以上
     */
    private String name;
    /**
     * 状态 true为正常，false为冻结
     */
    private Boolean status;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;
    /**
     * 类型名称
     */
    private String typeName;
}
