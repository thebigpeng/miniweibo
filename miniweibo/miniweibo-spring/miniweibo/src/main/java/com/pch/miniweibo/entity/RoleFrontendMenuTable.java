package com.pch.miniweibo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * (SysRoleFrontendMenuTable)实体类
 *
 * @author makejava
 * @since 2023-04-20 22:21:33
 */
public class RoleFrontendMenuTable extends Model<RoleFrontendMenuTable> {
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private Integer id;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 前端菜单管理ID
     */
    private String frontendMenuId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getFrontendMenuId() {
        return frontendMenuId;
    }

    public void setFrontendMenuId(String frontendMenuId) {
        this.frontendMenuId = frontendMenuId;
    }

    /**
     * (SysFrontendMenuTable)实体类
     *
     * @author makejava
     * @since 2023-04-22 07:51:03
     */
    public static class SysFrontendMenuTable implements Serializable {
        private static final long serialVersionUID = -99677494516128879L;
        /**
         * 主键
         */
        private String frontendMenuId;
        /**
         * 前端菜单名称
         */
        private String frontendMenuName;
        /**
         * 前端菜单访问HTML地址
         */
        private String frontendMenuUrl;
        /**
         * 父ID
         */
        private String pid;
        /**
         * 排序
         */
        private Integer frontendMenuSort;
        /**
         * 描述
         */
        private String description;


        public String getFrontendMenuId() {
            return frontendMenuId;
        }

        public void setFrontendMenuId(String frontendMenuId) {
            this.frontendMenuId = frontendMenuId;
        }

        public String getFrontendMenuName() {
            return frontendMenuName;
        }

        public void setFrontendMenuName(String frontendMenuName) {
            this.frontendMenuName = frontendMenuName;
        }

        public String getFrontendMenuUrl() {
            return frontendMenuUrl;
        }

        public void setFrontendMenuUrl(String frontendMenuUrl) {
            this.frontendMenuUrl = frontendMenuUrl;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public Integer getFrontendMenuSort() {
            return frontendMenuSort;
        }

        public void setFrontendMenuSort(Integer frontendMenuSort) {
            this.frontendMenuSort = frontendMenuSort;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
}

