package com.example.demo.bean;

public class TDataSchoolInfoWithBLOBs extends TDataSchoolInfo {
    /**
     * 招生范围
     */
    private String frecruitScope;

    /**
     * 招生简章
     */
    private String frecruitBrochure;

    public String getFrecruitScope() {
        return frecruitScope;
    }

    public void setFrecruitScope(String frecruitScope) {
        this.frecruitScope = frecruitScope;
    }

    public String getFrecruitBrochure() {
        return frecruitBrochure;
    }

    public void setFrecruitBrochure(String frecruitBrochure) {
        this.frecruitBrochure = frecruitBrochure;
    }
}