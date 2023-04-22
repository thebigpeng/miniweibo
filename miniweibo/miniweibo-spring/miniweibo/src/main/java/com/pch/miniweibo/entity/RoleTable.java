package com.pch.miniweibo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * (SysRoleTable)实体类
 *
 * @author makejava
 * @since 2023-04-20 21:17:40
 */
public class RoleTable extends Model<RoleTable> {
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String roleId;
    /**
     * 角色ID
     */
    private String roleName;
    /**
     * 描述
     */
    private String description;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

