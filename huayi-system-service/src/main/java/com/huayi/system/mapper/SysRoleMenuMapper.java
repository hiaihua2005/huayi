package com.huayi.system.mapper;

import java.util.List;

import com.huayi.system.condition.system.SysRoleMenuCondition;
import com.huayi.system.domain.SysRoleMenu;

/**
 * 角色与菜单关联表 数据层
 * 
 * @author huayi
 */
public interface SysRoleMenuMapper
{
    /**
     * 通过角色ID删除角色和菜单关联
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleMenuByRoleId(Long roleId);
    
    /**
     * 批量删除角色菜单关联信息
     * 
     * @param condition 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleMenuByRoleCondition(SysRoleMenuCondition condition);

    /**
     * 批量删除角色菜单关联信息
     *
     * @param condition 需要删除条件
     * @return 结果
     */
    public int batchDeleteRoleMenu(SysRoleMenuCondition condition);
    
    /**
     * 查询菜单使用数量
     * 
     * @param menuId 菜单ID
     * @return 结果
     */
    public int selectCountRoleMenuByMenuId(Long menuId);
    
    /**
     * 批量新增角色菜单信息
     * 
     * @param roleMenuList 角色菜单列表
     * @return 结果
     */
    public int batchRoleMenu(List<SysRoleMenu> roleMenuList);

    /**
     * 查询角色菜单
     * @param condition
     * @return
     */
    public List<SysRoleMenu> selectRoleMenuList(SysRoleMenuCondition condition);
}
