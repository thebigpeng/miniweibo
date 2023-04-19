package com.pch.miniweibo.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * @className: SysBackendApiVO
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/19
 */
public class BackendApiVO extends Model<BackendApiVO> {
    @TableId(type = IdType.UUID)
    private String backendApiId;

    private String backendApiName;

    private String pid;

    private String backendApiUrl;

    private String backendApiMethod;

    private Integer backendApiSort;

    private String description;

    String parentName;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public BackendApiVO() {
    }

    public BackendApiVO(String backendApiId, String backendApiName, String pid, String backendApiUrl, String backendApiMethod, Integer backendApiSort, String description) {
        this.backendApiId = backendApiId;
        this.backendApiName = backendApiName;
        this.pid = pid;
        this.backendApiUrl = backendApiUrl;
        this.backendApiMethod = backendApiMethod;
        this.backendApiSort = backendApiSort;
        this.description = description;
    }

    public String getBackendApiId() {
        return backendApiId;
    }

    public void setBackendApiId(String backendApiId) {
        this.backendApiId = backendApiId;
    }

    public String getBackendApiName() {
        return backendApiName;
    }

    public void setBackendApiName(String backendApiName) {
        this.backendApiName = backendApiName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getBackendApiUrl() {
        return backendApiUrl;
    }

    public void setBackendApiUrl(String backendApiUrl) {
        this.backendApiUrl = backendApiUrl;
    }

    public String getBackendApiMethod() {
        return backendApiMethod;
    }


    public void setBackendApiMethod(String backendApiMethod) {
        this.backendApiMethod = backendApiMethod;
    }

    public Integer getBackendApiSort() {
        return backendApiSort;
    }

    public void setBackendApiSort(Integer backendApiSort) {
        this.backendApiSort = backendApiSort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.backendApiId;
    }
}
