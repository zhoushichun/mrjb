
package com.cqmrjb.common.result;


import java.io.Serializable;



public class Result<T> implements Serializable {

    /**操作代码*/
    int code;

    /**提示信息*/
    String message;

    /**结果数据*/
    T data;

    public Result(RCode rCode){
        this.code = rCode.code();
        this.message = rCode.message();
    }

    public Result(RCode rCode, T data){
        this.code = rCode.code();
        this.message = rCode.message();
        this.data = data;
    }

    public Result(String message){
        this.message = message;
    }

    public static Result SUCCESS(){
        return new Result(RCode.SUCCESS);
    }

    public static <T> Result SUCCESS(T data){
        return new Result(RCode.SUCCESS, data);
    }

    public static Result FAIL(){
        return new Result(RCode.FAIL);
    }

    public static Result FAIL(String message){
        return new Result(message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
