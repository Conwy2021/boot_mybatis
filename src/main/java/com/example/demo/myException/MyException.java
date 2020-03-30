package com.example.demo.myException;

import java.io.PrintStream;

/**
 * @Author:LiuKangwei
 * @Date:2020/3/29 23:05
 * @Description:
 */
public class MyException extends   RuntimeException{
    private static final long serialVersionUID = 1L;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MyException(String msg) {
        super(msg);
    }
    //默认构造函数会自已生成
    public MyException() {
        super();
    }
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }



    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
    }
}
