package com.pch.miniweibo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.miniweibo.VO.FrontendVo;
import com.pch.miniweibo.dao.FrontendMenuTableDao;
import com.pch.miniweibo.entity.FrontendMenuTable;
import com.pch.miniweibo.entity.RoleFrontendMenuTable;
import com.pch.miniweibo.service.FrontendMenuTableService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: RoleFrontendMenuTableServiceImpl
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/22
 */
@Service("frontendMenuTableService")
public class FrontendMenuTableServiceImpl extends ServiceImpl<FrontendMenuTableDao, FrontendMenuTable> implements FrontendMenuTableService {


    @Override
    public List<FrontendVo> getAllMenuList() {
        return this.baseMapper.getAllMenuList();
    }

    @Override
    public List<FrontendMenuTable> getMenusByUserName(String username) {
        return this.baseMapper.getMenusByUserName(username);
    }
}
