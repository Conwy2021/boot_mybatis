package com.example.demo.bean;

public class TDataSchoolWithBLOBs extends TDataSchool {
    /**
     * 学校简介
     */
    private String fschoolProfile;

    /**
     * 师资力量
     */
    private String fteacherStrength;

    public String getFschoolProfile() {
        return fschoolProfile;
    }

    public void setFschoolProfile(String fschoolProfile) {
        this.fschoolProfile = fschoolProfile;
    }

    public String getFteacherStrength() {
        return fteacherStrength;
    }

    public void setFteacherStrength(String fteacherStrength) {
        this.fteacherStrength = fteacherStrength;
    }
}