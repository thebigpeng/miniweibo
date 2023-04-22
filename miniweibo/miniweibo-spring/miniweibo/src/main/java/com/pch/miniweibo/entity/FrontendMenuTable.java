package com.pch.miniweibo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.Serializable;

/**
 * (SysFrontendMenuTable)实体类
 *
 * @author makejava
 * @since 2023-04-22 07:58:20
 */
public class FrontendMenuTable extends Model<FrontendMenuTable> {
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
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

