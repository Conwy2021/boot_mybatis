package com.example.demo.bean;

import java.util.Date;

public class TDataSchoolIncondition {
    /**
     * 主键
     */
    private String fid;

    /**
     * 名称
     */
    private String fname;

    /**
     * 简称
     */
    private String fsimplePinyin;

    /**
     * 外键，区域ID，关联T_DATA_AREA.FID
     */
    private String fcityId;

    /**
     */
    private String fareaId;

    /**
     * 内容图片
     */
    private String fimageurl;

    /**
     * 创建时间
     */
    private Date fcreateTime;

    /**
     * 最后修改时间
     */
    private Date fupdateTime;

    /**
     * 创建人ID
     */
    private String fcreateOperatorId;

    /**
     * 最后修改人ID
     */
    private String fupdateOperatorId;

    /**
     */
    private String fdelete;

    /**
     * 条件内容
     */
    private String fcontent;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFsimplePinyin() {
        return fsimplePinyin;
    }

    public void setFsimplePinyin(String fsimplePinyin) {
        this.fsimplePinyin = fsimplePinyin;
    }

    public String getFcityId() {
        return fcityId;
    }

    public void setFcityId(String fcityId) {
        this.fcityId = fcityId;
    }

    public String getFareaId() {
        return fareaId;
    }

    public void setFareaId(String fareaId) {
        this.fareaId = fareaId;
    }

    public String getFimageurl() {
        return fimageurl;
    }

    public void setFimageurl(String fimageurl) {
        this.fimageurl = fimageurl;
    }

    public Date getFcreateTime() {
        return fcreateTime;
    }

    public void setFcreateTime(Date fcreateTime) {
        this.fcreateTime = fcreateTime;
    }

    public Date getFupdateTime() {
        return fupdateTime;
    }

    public void setFupdateTime(Date fupdateTime) {
        this.fupdateTime = fupdateTime;
    }

    public String getFcreateOperatorId() {
        return fcreateOperatorId;
    }

    public void setFcreateOperatorId(String fcreateOperatorId) {
        this.fcreateOperatorId = fcreateOperatorId;
    }

    public String getFupdateOperatorId() {
        return fupdateOperatorId;
    }

    public void setFupdateOperatorId(String fupdateOperatorId) {
        this.fupdateOperatorId = fupdateOperatorId;
    }

    public String getFdelete() {
        return fdelete;
    }

    public void setFdelete(String fdelete) {
        this.fdelete = fdelete;
    }

    public String getFcontent() {
        return fcontent;
    }

    public void setFcontent(String fcontent) {
        this.fcontent = fcontent;
    }

    @Override
    public String toString() {
        return "TDataSchoolIncondition{" +
                "fid='" + fid + '\'' +
                ", fname='" + fname + '\'' +
                ", fsimplePinyin='" + fsimplePinyin + '\'' +
                ", fcityId='" + fcityId + '\'' +
                ", fareaId='" + fareaId + '\'' +
                ", fimageurl='" + fimageurl + '\'' +
                ", fcreateTime=" + fcreateTime +
                ", fupdateTime=" + fupdateTime +
                ", fcreateOperatorId='" + fcreateOperatorId + '\'' +
                ", fupdateOperatorId='" + fupdateOperatorId + '\'' +
                ", fdelete='" + fdelete + '\'' +
                ", fcontent='" + fcontent + '\'' +
                '}';
    }
}