package com.pch.miniweibo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pch.miniweibo.VO.FrontendVo;
import com.pch.miniweibo.entity.FrontendMenuTable;
import com.pch.miniweibo.entity.RoleFrontendMenuTable;

import java.util.List;

/**
 * (SysRoleFrontendMenuTable)表服务接口
 *
 * @author makejava
 * @since 2023-04-20 22:21:36
 */
public interface FrontendMenuTableService extends IService<FrontendMenuTable> {

    /**
     * 查所有的前端菜单（编辑使用）
     */
    List<FrontendVo> getAllMenuList();

    /**
     * 根据登录账号，获得前端展现的菜单
     * 控制前端菜单的权限
     * @param username
     * @return
     */
    List<FrontendMenuTable> getMenusByUserName(String username);
}
