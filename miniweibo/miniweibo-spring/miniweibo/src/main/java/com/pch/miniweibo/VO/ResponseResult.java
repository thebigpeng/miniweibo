package com.pch.miniweibo.VO;

/**
 * @className: ResponseResult
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/22
 **/
public class ResponseResult<T> {
    private T data;
    private String code;
    private String desc;
    public ResponseResult(T t, String code, String desc){
        this.code = code;
        this.data = t;
        this.desc = desc;
    }
}
