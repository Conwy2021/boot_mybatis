package com.example.test_10.bean;

import java.util.Date;

public class Invitation {
    /**
     * 主键 帖子编号 自增
     */
    private Integer id;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子摘要
     */
    private String summary;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}