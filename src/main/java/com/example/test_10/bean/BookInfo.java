package com.example.test_10.bean;

import java.io.Serializable;
import java.util.Date;

public class BookInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 图书ID
     */
    private Integer bookId;

    /**
     * 图书编号
     */
    private String bookCode;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 图书类型
     */
    private Integer bookType;

    /**
     * 图书作者
     */
    private Integer bookAuthor;

    /**
     * 出版社
     */
    private String publishPress;

    /**
     * 出版日期
     */
    private Date publishDate;

    /**
     * 是否借阅（1、已借阅0、未借阅）
     */
    private String isBorrow;

    /**
     * 创建人
     */
    private String createdby;

    /**
     * 创建时间
     */
    private Date creationTime;

    /**
     * 最新更新时间
     */
    private Date lastUpdatetime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Integer getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Integer bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getPublishPress() {
        return publishPress;
    }

    public void setPublishPress(String publishPress) {
        this.publishPress = publishPress;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(String isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdatetime() {
        return lastUpdatetime;
    }

    public void setLastUpdatetime(Date lastUpdatetime) {
        this.lastUpdatetime = lastUpdatetime;
    }
}