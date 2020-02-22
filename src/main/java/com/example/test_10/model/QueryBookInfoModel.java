package com.example.test_10.model;

import lombok.Data;

/**
 * @Author:LiuKangwei
 * @Date:2019/10/22 23:10
 * @Description:
 */
@Data
public class QueryBookInfoModel {

    /**
     * 图书编号
     */
    private String bookCode;

    /**
     *图书分类（小说、文学、传记、艺术、少儿、经济、管理、科技）
     */
    private Integer bookType;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 图书作者
     */
    private Integer bookAuthor;


    /**
     * 出版社
     */
    private String publishPress;

    /**
     * 是否借阅（1、已借阅0、未借阅）
     */
    private String isBorrow;
}
