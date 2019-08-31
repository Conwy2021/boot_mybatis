package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TDataSchoolInfo {
    /**
     * 主键
     */
    private String fid;

    /**
     * 外键，学校id 关联 T_DATA_SCHOOL.FID
     */
    private String fschoolId;

    /**
     * 年份
     */
    private String fyear;

    /**
     * 班级数
     */
    private Long fclassNumber;

    /**
     * 招生数
     */
    private BigDecimal fenrollmentNumber;

    /**
     *  入学积分
     */
    private String fentrancePoints;

    /**
     * 外键，入学条件关联 T_DATA_SCHOOL_INCONDITION.FID
     */
    private String finconditionId;

    /**
     * 招生数类型 TYPECLASS =班,
    TYPEGRADE=年级
     */
    private String fenrollmentNumberType;

    /**
     * 创建时间
     */
    private Date fcreateTime;

    /**
     * 最后更新时间
     */
    private Date fupdateTime;

    /**
     * 创建人
     */
    private String fcreateOperatorId;

    /**
     * 更新人
     */
    private String fupdateOperatorId;

    /**
     */
    private String fdelete;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFschoolId() {
        return fschoolId;
    }

    public void setFschoolId(String fschoolId) {
        this.fschoolId = fschoolId;
    }

    public String getFyear() {
        return fyear;
    }

    public void setFyear(String fyear) {
        this.fyear = fyear;
    }

    public Long getFclassNumber() {
        return fclassNumber;
    }

    public void setFclassNumber(Long fclassNumber) {
        this.fclassNumber = fclassNumber;
    }

    public BigDecimal getFenrollmentNumber() {
        return fenrollmentNumber;
    }

    public void setFenrollmentNumber(BigDecimal fenrollmentNumber) {
        this.fenrollmentNumber = fenrollmentNumber;
    }

    public String getFentrancePoints() {
        return fentrancePoints;
    }

    public void setFentrancePoints(String fentrancePoints) {
        this.fentrancePoints = fentrancePoints;
    }

    public String getFinconditionId() {
        return finconditionId;
    }

    public void setFinconditionId(String finconditionId) {
        this.finconditionId = finconditionId;
    }

    public String getFenrollmentNumberType() {
        return fenrollmentNumberType;
    }

    public void setFenrollmentNumberType(String fenrollmentNumberType) {
        this.fenrollmentNumberType = fenrollmentNumberType;
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
}