package com.example.wytest;

public class OneTest {
    private int a;
    private Address b;
    private Address c;
    public OneTest(int a,Address b,Address c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public Address getB() {
        return b;
    }

    public void setB(Address b) {
        this.b = b;
    }

    public Address getC() {
        return c;
    }

    public void setC(Address c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "OneTest{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public String toString1() {
        return "OneTest{" +
                "a1=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
