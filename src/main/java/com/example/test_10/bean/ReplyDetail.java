package com.example.test_10.bean;

import java.util.Date;

public class ReplyDetail {
    /**
     * 编号 主键自增
     */
    private Integer id;

    /**
     * 对应帖子表的主键
     */
    private Integer invid;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 默认“匿名用户”
     */
    private String author;

    /**
     * 回复时间
     */
    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvid() {
        return invid;
    }

    public void setInvid(Integer invid) {
        this.invid = invid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "ReplyDetail{" +
                "id=" + id +
                ", invid=" + invid +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdate=" + createdate +
                '}';
    }
}