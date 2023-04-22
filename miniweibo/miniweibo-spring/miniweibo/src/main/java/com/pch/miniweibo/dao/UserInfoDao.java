package com.pch.miniweibo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.miniweibo.VO.UserVO;
import com.pch.miniweibo.entity.FrontendMenuTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @className: UserInfoDao
 * @description: TODO 类描述
 * @author: pengchenhui
 * @date: 2022/9/20
 **/
public interface UserInfoDao extends BaseMapper<UserVO>{
    /**
     * (SysFrontendMenuTable)表数据库访问层
     *
     * @author makejava
     * @since 2023-04-22 07:51:01
     */
    interface SysFrontendMenuTableDao {

        /**
         * 通过ID查询单条数据
         *
         * @param frontendMenuId 主键
         * @return 实例对象
         */
        FrontendMenuTable queryById(String frontendMenuId);

        /**
         * 查询指定行数据
         *
         * @param sysFrontendMenuTable 查询条件
         * @param pageable         分页对象
         * @return 对象列表
         */
        List<FrontendMenuTable> queryAllByLimit(FrontendMenuTable sysFrontendMenuTable, @Param("pageable") Pageable pageable);

        /**
         * 统计总行数
         *
         * @param sysFrontendMenuTable 查询条件
         * @return 总行数
         */
        long count(FrontendMenuTable sysFrontendMenuTable);

        /**
         * 新增数据
         *
         * @param sysFrontendMenuTable 实例对象
         * @return 影响行数
         */
        int insert(FrontendMenuTable sysFrontendMenuTable);

        /**
         * 批量新增数据（MyBatis原生foreach方法）
         *
         * @param entities List<SysFrontendMenuTable> 实例对象列表
         * @return 影响行数
         */
        int insertBatch(@Param("entities") List<FrontendMenuTable> entities);

        /**
         * 批量新增或按主键更新数据（MyBatis原生foreach方法）
         *
         * @param entities List<SysFrontendMenuTable> 实例对象列表
         * @return 影响行数
         * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
         */
        int insertOrUpdateBatch(@Param("entities") List<FrontendMenuTable> entities);

        /**
         * 修改数据
         *
         * @param sysFrontendMenuTable 实例对象
         * @return 影响行数
         */
        int update(FrontendMenuTable sysFrontendMenuTable);

        /**
         * 通过主键删除数据
         *
         * @param frontendMenuId 主键
         * @return 影响行数
         */
        int deleteById(String frontendMenuId);

    }
}
