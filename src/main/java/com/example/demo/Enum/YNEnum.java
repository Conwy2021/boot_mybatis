package com.example.demo.Enum;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/23 0:11
 * @Description:
 */
public enum YNEnum {
    YES(1),NO(0);

    private final int i;
    YNEnum(int i) {
        this.i=i;
    }

    public int getName(){
        return this.i;
    }
}
