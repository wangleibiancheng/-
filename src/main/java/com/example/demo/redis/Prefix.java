package com.example.demo.redis;

public interface Prefix {
    public int expireSeconds();
    public String getPrefix();
}
