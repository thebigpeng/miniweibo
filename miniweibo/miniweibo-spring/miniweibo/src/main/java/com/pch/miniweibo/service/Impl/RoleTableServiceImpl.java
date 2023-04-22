package com.pch.miniweibo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.miniweibo.dao.RoleTableDao;
import com.pch.miniweibo.VO.RoleAndPermissionVo;
import com.pch.miniweibo.entity.RoleTable;
import com.pch.miniweibo.service.RoleTableService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: RoleTableServiceImpl
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/20
 */
@Service("roleTableService")
public class RoleTableServiceImpl extends ServiceImpl<RoleTableDao, RoleTable> implements RoleTableService {
    @Override
    public List<String> getRoleByUserName(String userName) {
        return this.baseMapper.getRolesByUserName(userName);
    }

    @Override
    public List<RoleAndPermissionVo> getRoleAndUserList(String roleId) {
        return this.baseMapper.getRoleAndUserList(roleId);
    }

    @Override
    public List<RoleAndPermissionVo> getRoleAndMenuList(String roleId) {
        return this.baseMapper.getRoleAndMenuList(roleId);
    }
}
