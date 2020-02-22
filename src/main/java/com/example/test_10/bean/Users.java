package com.example.test_10.bean;

import java.io.Serializable;
import java.util.Date;


public class Users implements Serializable {


    private static final long serialVersionUID = -310680107090528244L;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户编码
     */
    private String userCode;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 性别(1男0女)
     */
    private String gender;

    /**
     * 注册日期
     */
    private Date registerTime;

    /**
     * 最后登录时间
     */
    private Date lastLogintime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", userCode='" + userCode + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", registerTime=" + registerTime +
                ", lastLogintime=" + lastLogintime +
                '}';
    }
}