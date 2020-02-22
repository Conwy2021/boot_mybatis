package com.example.test_10.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 22:28
 * @Description:
 */
@Data
public class QueryPage implements Serializable {

    private static final long serialVersionUID = 1608867252649526326L;
    /**
     * 当前页
     */
    private Integer page = 1;

    /**
     * 每页的记录数
     */
    private Integer limit = 5;
}
