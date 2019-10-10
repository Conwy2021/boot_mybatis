package com.example.demo.Enum;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/23 0:26
 * @Description:
 */
public enum DemoEnum {
    chun(1,"春天"),xia(2,"夏");

    private int i;
    private String str;
    DemoEnum(int i, String str) {
        this.i=i;
        this.str=str;
    }

    public int getI() {
        return i;
    }

    public String getStr() {
        return str;
    }
}
