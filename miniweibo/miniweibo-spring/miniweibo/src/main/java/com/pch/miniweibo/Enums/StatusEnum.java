package com.pch.miniweibo.Enums;

/**
 * @className: SuccessEnum
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/22
 **/
public enum StatusEnum {
    REQUEST_SUCCESS("201", "请求成功"),
    LOGIN_SUCCESS("202", "登录成功"),
    REGISIT_SUCCESS("203", "注册成功"),

    LOGIN_FAILD("202", "登录失败"),
    REGISIT_FAILD("402", "注册失败");

    private String code;

    private String desc;

    StatusEnum(String code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
