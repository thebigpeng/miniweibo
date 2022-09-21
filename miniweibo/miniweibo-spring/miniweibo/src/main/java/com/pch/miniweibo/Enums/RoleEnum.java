package com.pch.miniweibo.Enums;

/**
 * @className: RoleEnum
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/21
 **/
public enum RoleEnum {
    GENERAL_USER("GENERAL_USER", "一般用户"),
    ROLE_ADMIN("ROLE_ADMIN", "管理员账户");
    private String roleName;
    private String desc;

    private RoleEnum(String roleName, String desc){
        this.roleName  = roleName;
        this.roleName = desc;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
