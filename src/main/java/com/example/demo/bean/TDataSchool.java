package com.example.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TDataSchool {
    /**
     */
    private String fid;

    /**
     * 登记名
     */
    private String fname;

    /**
     * 简拼
     */
    private String fsimplePinyin;

    /**
     * 别名
     */
    private String faliasName;

    /**
     * 纬度
     */
    private BigDecimal flat;

    /**
     * 经度
     */
    private BigDecimal flng;

    /**
     * 外键，城市id，关联T_DATA_AREA.FID
     */
    private String fcityId;

    /**
     * 外键，区域id，关联T_DATA_AREA.FID
     */
    private String fareaId;

    /**
     * 外键，片区id，关联T_DATA_AREA.FID
     */
    private String fgeographyAreaId;

    /**
     * 详细地址
     */
    private String faddress;

    /**
     * 学校类别: KINDERGARTEN=幼儿园,
    PRIMARYSCHOOL=小学,
    JUNIORSCHOOL=初中,
    HIGHSCHOOL=高中,
    SPECIALSCHOOLS=特殊学校,
    NINEYEARCONSISTENCY=九年一贯,
    TWELVEYEARCONSISTENCY=十二年一贯,
    COMPLETESCHOOL=完全学校
     */
    private String fschoolType;

    /**
     * 学校子类别: KINDERGARTEN=幼儿园,PRIMARYSCHOOL=小学,
    JUNIORSCHOOL=初中,
    HIGHSCHOOL=高中,SPECIALSCHOOLS=特殊学校
     */
    private String fschoolSubType;

    /**
     * 学校等级: NO=无等级,
    PROVINCE=省一级,
    CITY=市一级,
    AREA=区一级
     */
    private String fschoolGrade;

    /**
     * 升学方式:    ASSIGNMENT=派位,
    COUNTERPARTRISING=对口直升,
    NINEYEARCONSISTENCY=九年一贯,
    TWELVEYEARCONSISTENCY=十二年一贯,
    GIVEPRIORITY=推优,
    INDEPENDENTENROLLMENT=自主招生,
     */
    private String fentranceWay;

    /**
     * 学位锁定:    NO=,
    LOCK=锁定,
    UNLOCK=未锁定
     */
    private String fdegreeLock;

    /**
     * 名额规定: THREE=三年一名额,
    SIX=六年一名额,
    NINE=九年一名额,
     */
    private String fquota;

    /**
     * 外键 所属大学区/集团 id,关联T_DATA_SCHOOL_DISTRICT.FID
     */
    private String fdistrictId;

    /**
     * 学校性质:    PUBLICRUN =公办,
    CIVILRUN=民办,
     */
    private String fschoolNature;

    /**
     * 招生电话
     */
    private String fphone;

    /**
     * 官网地址
     */
    private String fwebsite;

    /**
     * 硬件设施
     */
    private String ffacilities;

    /**
     * 所获奖项
     */
    private String fawards;

    /**
     * 学校特色
     */
    private String ffeature;

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
     * 逻辑删除，YES删除 NO未删除
     */
    private String fdelete;

    /**
     * 关联小区数
     */
    private Long frelationGarden;

    /**
     * 关联小区坐标字符串   多个坐标用#隔开 同经纬度以英文逗号隔开（纬度，经度#纬度,经度）
     */
    private String fscopeLatLng;

    /**
     * 是否有图：YES=是, NO=否
     */
    private String fisPicture;

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

    public String getFaliasName() {
        return faliasName;
    }

    public void setFaliasName(String faliasName) {
        this.faliasName = faliasName;
    }

    public BigDecimal getFlat() {
        return flat;
    }

    public void setFlat(BigDecimal flat) {
        this.flat = flat;
    }

    public BigDecimal getFlng() {
        return flng;
    }

    public void setFlng(BigDecimal flng) {
        this.flng = flng;
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

    public String getFgeographyAreaId() {
        return fgeographyAreaId;
    }

    public void setFgeographyAreaId(String fgeographyAreaId) {
        this.fgeographyAreaId = fgeographyAreaId;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFschoolType() {
        return fschoolType;
    }

    public void setFschoolType(String fschoolType) {
        this.fschoolType = fschoolType;
    }

    public String getFschoolSubType() {
        return fschoolSubType;
    }

    public void setFschoolSubType(String fschoolSubType) {
        this.fschoolSubType = fschoolSubType;
    }

    public String getFschoolGrade() {
        return fschoolGrade;
    }

    public void setFschoolGrade(String fschoolGrade) {
        this.fschoolGrade = fschoolGrade;
    }

    public String getFentranceWay() {
        return fentranceWay;
    }

    public void setFentranceWay(String fentranceWay) {
        this.fentranceWay = fentranceWay;
    }

    public String getFdegreeLock() {
        return fdegreeLock;
    }

    public void setFdegreeLock(String fdegreeLock) {
        this.fdegreeLock = fdegreeLock;
    }

    public String getFquota() {
        return fquota;
    }

    public void setFquota(String fquota) {
        this.fquota = fquota;
    }

    public String getFdistrictId() {
        return fdistrictId;
    }

    public void setFdistrictId(String fdistrictId) {
        this.fdistrictId = fdistrictId;
    }

    public String getFschoolNature() {
        return fschoolNature;
    }

    public void setFschoolNature(String fschoolNature) {
        this.fschoolNature = fschoolNature;
    }

    public String getFphone() {
        return fphone;
    }

    public void setFphone(String fphone) {
        this.fphone = fphone;
    }

    public String getFwebsite() {
        return fwebsite;
    }

    public void setFwebsite(String fwebsite) {
        this.fwebsite = fwebsite;
    }

    public String getFfacilities() {
        return ffacilities;
    }

    public void setFfacilities(String ffacilities) {
        this.ffacilities = ffacilities;
    }

    public String getFawards() {
        return fawards;
    }

    public void setFawards(String fawards) {
        this.fawards = fawards;
    }

    public String getFfeature() {
        return ffeature;
    }

    public void setFfeature(String ffeature) {
        this.ffeature = ffeature;
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

    public Long getFrelationGarden() {
        return frelationGarden;
    }

    public void setFrelationGarden(Long frelationGarden) {
        this.frelationGarden = frelationGarden;
    }

    public String getFscopeLatLng() {
        return fscopeLatLng;
    }

    public void setFscopeLatLng(String fscopeLatLng) {
        this.fscopeLatLng = fscopeLatLng;
    }

    public String getFisPicture() {
        return fisPicture;
    }

    public void setFisPicture(String fisPicture) {
        this.fisPicture = fisPicture;
    }
}