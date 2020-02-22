package com.example.test_10.form;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 22:23
 * @Description:
 */
@Data
public class QueryBookInfoForm implements Serializable {

    private static final long serialVersionUID = 2124991131844492873L;

    /**
     *关键字对应图书名称
     */
    private String keyword;

    /**
     *图书分类（小说、文学、传记、艺术、少儿、经济、管理、科技）
     */
    private List<Integer> bookTypeList;

    /**
     * 是否借阅（1、已借阅0、未借阅）
     */
    private List<String> isBorrowList;

}
