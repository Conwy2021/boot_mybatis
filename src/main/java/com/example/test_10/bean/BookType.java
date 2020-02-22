package com.example.test_10.bean;

import java.io.Serializable;

public class BookType implements Serializable {


    private static final long serialVersionUID = -4952412060700993908L;
    /**
     * id
     */
    private Integer id;

    /**
     * 图书类型名称
     */
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}