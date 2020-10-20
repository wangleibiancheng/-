package com.example.demo.result;

/**
 * @author wanglei
 * @date 2020/10/20 4:31 下午
 * @File : Result.java
 */

public class Result<T> {
    private int code;
    private String message;
    private T date;

    public Result(T date) {
        this.code=0;
        this.message="成功";
        this.date=date;
    }

    public Result(CodeMessage cm) {
        this.code=cm.getCode();
        this.message=cm.getMessage();
    }

    public static <T> Result<T> success(T date){
        return new Result<T>(date);
    }
    public static <T> Result<T> error(CodeMessage cm){
        return new Result<T>(cm);
    }

}
