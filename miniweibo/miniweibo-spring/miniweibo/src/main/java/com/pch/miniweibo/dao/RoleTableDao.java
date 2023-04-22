package com.pch.miniweibo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.miniweibo.VO.RoleAndPermissionVo;
import com.pch.miniweibo.entity.RoleTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (SysRoleTable)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-20 21:17:40
 */
public interface RoleTableDao extends BaseMapper<RoleTable> {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    RoleTable queryById(String roleId);

    /**
     * 查询指定行数据
     *
     * @param roleTable 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RoleTable> queryAllByLimit(RoleTable roleTable, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param roleTable 查询条件
     * @return 总行数
     */
    long count(RoleTable roleTable);

    /**
     * 新增数据
     *
     * @param roleTable 实例对象
     * @return 影响行数
     */
    int insert(RoleTable roleTable);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleTable> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoleTable> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleTable> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RoleTable> entities);

    /**
     * 修改数据
     *
     * @param roleTable 实例对象
     * @return 影响行数
     */
    int update(RoleTable roleTable);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(String roleId);

    @Select("SELECT b.role_name\n" +
            "from sys_user_table a,\n" +
            "\t sys_role_table b,\n" +
            "     sys_role_user_table c\n" +
            "where a.user_id = c.user_id\n" +
            "     and b.role_id = c.role_id\n" +
            "     and a.state = 1\n"+
            "     and a.user_name=#{userName}")
    List<String> getRolesByUserName(@Param("userName") String userName);


    @Select("SELECT \n" +
            "    t1.user_id as id, \n" +
            "    t1.user_name as name, \n" +
            "    t2.role_id \n" +
            "FROM\n" +
            "    sys_user_table t1\n" +
            "        LEFT JOIN\n" +
            "    (SELECT \n" +
            "        a.user_id, a.user_name, b.role_id, b.role_name\n" +
            "    FROM\n" +
            "        sys_user_table a\n" +
            "    JOIN (sys_role_table b\n" +
            "    JOIN sys_role_user_table c ON c.role_id = b.role_id) ON c.user_id = a.user_id\n" +
            "    WHERE\n" +
            "        b.role_id = #{roleId}) t2 ON t2.user_id = t1.user_id")
    /**
     * 根据roleId找用户以及用户是否被设置在某个角色上，用在显示在用于角色设置处
     */
    List<RoleAndPermissionVo> getRoleAndUserList(@Param("roleId") String roleId);


    @Select("select \n" +
            "  t1.frontend_menu_id as id,\n" +
            "  t1.frontend_menu_name as name ,\n" +
            "  t1.pid as pid,\n" +
            "  t2.role_id as role_id\n" +
            "from sys_frontend_menu_table t1 \n" +
            "left join\n" +
            "(\n" +
            "   select \n" +
            "     a.frontend_menu_id,\n" +
            "     a.frontend_menu_name,\n" +
            "     a.pid,\n" +
            "     a.frontend_menu_sort,\n" +
            "     b.role_id\n" +
            "   from sys_frontend_menu_table a, \n" +
            "     sys_role_table b, \n" +
            "     sys_role_frontend_menu_table c\n" +
            "   where  ( a.frontend_menu_id = c.frontend_menu_id or c.frontend_menu_id='*')\n" +
            "\t and b.role_id = c.role_id\n" +
            "     and b.role_id = #{roleId}\n" +
            ") t2 on t2.frontend_menu_id = t1.frontend_menu_id\n" +
            "   order by t1.frontend_menu_sort asc")
    /**
     * 根据roleId找菜单
     */
    List<RoleAndPermissionVo> getRoleAndMenuList(@Param("roleId") String roleId);



    @Select("select \n" +
            "  t1.backend_api_id as id,\n" +
            "  CASE t1.backend_api_url \n" +
            "  WHEN 'none' THEN t1.backend_api_name\n" +
            "  ELSE  CONCAT(t1.backend_api_name,' (',t1.backend_api_url,' ,提交类型:',t1.backend_api_method,')')\n" +
            "  END as name ,\n" +
            "  t1.pid as pid,\n" +
            "  t2.role_id as role_id \n" +
            "from sys_backend_api_table t1 \n" +
            "left join\n" +
            "(\n" +
            "   select \n" +
            "     a.backend_api_id,\n" +
            "     a.backend_api_name,\n" +
            "     a.pid,\n" +
            "     a.backend_api_sort,\n" +
            "     b.role_id\n" +
            "   from sys_backend_api_table a, \n" +
            "     sys_role_table b, \n" +
            "     sys_role_backend_api_table c\n" +
            "   where  a.backend_api_id = c.backend_api_id\n" +
            "\t and b.role_id = c.role_id\n" +
            "     and b.role_id = #{roleId}\n" +
            ") t2 on t2.backend_api_id = t1.backend_api_id\n" +
            "   order by t1.backend_api_sort asc")
    /**
     * 根据roleId找API
     */
    List<RoleAndPermissionVo> getRoleAndApiList(@Param("roleId") String roleId);
}

