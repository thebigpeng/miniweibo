package com.pch.miniweibo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pch.miniweibo.service.ApiManngerService;
import com.pch.miniweibo.dao.BackendApiDao;
import com.pch.miniweibo.VO.BackendApiVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: ApiManngerServiceImpl
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2023/4/19
 */
@Service("apiManngerService")
public class ApiManngerServiceImpl extends ServiceImpl<BackendApiDao, BackendApiVO> implements ApiManngerService {
    @Override
    public List<BackendApiVO> getApiUrlByRoles(String... roles) {
        return this.baseMapper.getApiUrlByRoles(roles);
    }

    @Override
    public List<BackendApiVO> getApiUrlByUserName(String username) {
        System.out.println("getApiUrlByUserName.................");
        return this.baseMapper.getApiUrlByUserName(username);
    }

    @Override
    public List<BackendApiVO> getAllApiList() {
        return this.baseMapper.getAllApiList();
    }
}
