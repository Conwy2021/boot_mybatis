package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.bcel.internal.generic.DDIV;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Emp {
    /**
     * 员工编号
     *
     */
    @NotNull
    private Integer empno;

    /**
     * 员工名称
     */
    private String ename;

    /**
     * 岗位
     */
    private String job;

    /**
     * 上级编号
     */
    private Integer mgr;

    /**
     * 入职日期
     * js是出参格式发，
     * date是入参格式化
     */
//    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    /**
     * 工资
     */
    private Double sal;

    /**
     * 部门编号
     */
    private Integer deptno;




    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }



    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", deptno=" + deptno +
                '}';
    }
}