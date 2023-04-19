package com.pch.miniweibo.Api;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.miniweibo.VO.BackendApiVO;

import java.util.List;

/**
 * @className: ApiManngerService
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/19
 */
public interface ApiManngerService extends IService<BackendApiVO> {

    /**
     * 根据角色查询API接口URL
     * @param roles
     * @return
     */
    List<BackendApiVO> getApiUrlByRoles(String ...roles);

    /**
     * 根据用户名称查询API接口URL
     * @param username
     * @return
     */
    List<BackendApiVO> getApiUrlByUserName(String username);

    /**
     * 查所有（编辑使用）
     */
    List<BackendApiVO> getAllApiList();
}
