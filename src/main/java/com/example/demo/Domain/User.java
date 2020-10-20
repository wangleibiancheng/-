package com.example.demo.Domain;

import org.springframework.stereotype.Component;

/**
 * @author wanglei
 * @date 2020/10/20 11:37 上午
 * @File : User.java
 */
@Component
public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
