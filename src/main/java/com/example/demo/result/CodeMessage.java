package com.example.demo.result;

/**
 * @author wanglei
 * @date 2020/10/20 4:40 下午
 * @File : CodeMessage.java
 */

public class CodeMessage {
    private int code;
    private String message;
    public static CodeMessage SERVER_ERROR=new CodeMessage(500100,"服务端异常");
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
    public CodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
