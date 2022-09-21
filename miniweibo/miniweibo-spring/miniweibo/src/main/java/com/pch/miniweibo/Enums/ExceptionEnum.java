package com.pch.miniweibo.Enums;

/**
 * @className: ExceptionEnum
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 **/
public enum ExceptionEnum {

    USER_NOT_FOUND("301", "用户不存在"),
    PASSWORD_NOT_MATCH("302", "登录密码错误");

    private String code;

    private String msg;

    ExceptionEnum(String code, String msg){
        this.code= code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
