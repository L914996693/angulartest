package com.angular.angulartest.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseResult <T> implements Serializable {
    private boolean flag;   //是否成功
    private Integer code;   //返回码
    private String message; //返回消息
    private T data;         //返回数据

    public ResponseResult(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public ResponseResult(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public ResponseResult() {
        this.flag = true;
        this.code = 200;
        this.message = "操作成功!";
    }
}
