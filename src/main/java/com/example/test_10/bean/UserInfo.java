package com.example.test_10.bean;

import java.util.Date;

public class UserInfo {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名;长度6位（含）以上
     */
    private String name;

    /**
     * 密码;长度6位（含）以上
     */
    private String password;

    /**
     * 状态 true为正常，false为冻结
     */
    private Boolean status;

    /**
     * 最后修改时间
     * 在 yml中配置
     */
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8") 这个不好使
    private Date lastModifyTime;

    /**
     * 用户类型:对应用户类型表主键
     */
    private Integer typeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}