package com.example.demo.bean;

import java.util.List;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/22 21:40
 * @Description:
 */
public class OneToManyInsertFrom {

    private String name;

    private List<Student> studentList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "OneToManyInsertFrom{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList +
                '}';
    }
}
