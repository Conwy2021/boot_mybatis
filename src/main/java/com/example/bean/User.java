package com.example.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:LiuKangwei
 * @Date:2022/3/5 21:09
 * @Description:
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private String name;
    private int age;
    private String id_card;
}
