package com.pch.miniweibo.service;

import com.pch.miniweibo.VO.RoleAndPermissionVo;
import com.pch.miniweibo.entity.RoleTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SysRoleTable)表服务接口
 *
 * @author makejava
 * @since 2023-04-20 21:17:44
 */
public interface RoleTableService {


    /**
     * 根据用户名称查询角色
     * @param userName
     * @return
     */
    List<String> getRoleByUserName(String userName);

    List<RoleAndPermissionVo> getRoleAndUserList(String roleId);

    List<RoleAndPermissionVo> getRoleAndMenuList(String roleId);
}
