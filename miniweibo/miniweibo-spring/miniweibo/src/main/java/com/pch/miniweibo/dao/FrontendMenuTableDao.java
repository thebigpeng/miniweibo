package com.pch.miniweibo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pch.miniweibo.VO.FrontendVo;
import com.pch.miniweibo.entity.FrontendMenuTable;
import com.pch.miniweibo.entity.RoleFrontendMenuTable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (SysRoleFrontendMenuTable)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-20 22:21:33
 */
public interface FrontendMenuTableDao extends BaseMapper<FrontendMenuTable> {

    /**
     * 查询所有的前端菜单
     * @return
     */
    @Select("SELECT \n" +
            "  b.frontend_menu_id,\n" +
            "  a.frontend_menu_name parentName,\n" +
            "  b.pid,\n" +
            "  b.frontend_menu_name,\n" +
            "  b.frontend_menu_sort,\n" +
            "  b.frontend_menu_url,\n" +
            "  b.description\n" +
            "FROM sys_frontend_menu_table a \n" +
            "right join sys_frontend_menu_table b on b.pid =a.frontend_menu_id\n" +
            "order by b.frontend_menu_sort asc")
    List<FrontendVo> getAllMenuList();

    /**
     * 根据登录账号获取可展示的菜单
     * @param userName
     * @return
     */
    @Select("select distinct\n" +
            "     a.frontend_menu_id,\n" +
            "     a.frontend_menu_name,\n" +
            "     a.pid,\n" +
            "\t a.frontend_menu_url,\n" +
            "     a.frontend_menu_sort\n" +
            "from sys_frontend_menu_table a,\n" +
            "     sys_role_table b,\n" +
            "     sys_role_frontend_menu_table c,\n" +
            "     sys_user_table d,\n" +
            "     sys_role_user_table e\n" +
            "where ( a.frontend_menu_id = c.frontend_menu_id or c.frontend_menu_id='*')\n" +
            "\t and b.role_id = c.role_id\n" +
            "     and d.user_id = e.user_id\n" +
            "     and e.role_id = c.role_id\n" +
            "     and d.user_name=#{username}\n" +
            "order by a.frontend_menu_sort asc")
    List<FrontendMenuTable> getMenusByUserName(@Param("username") String userName);
}

