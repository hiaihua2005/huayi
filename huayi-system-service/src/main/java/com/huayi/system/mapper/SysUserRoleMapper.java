package com.huayi.system.mapper;

import java.util.List;

import com.huayi.system.condition.system.SysRoleUserUpdateCondition;
import com.huayi.system.condition.system.SysUserRoleCondition;
import com.huayi.system.domain.SysUserRole;

/**
 * 用户表 数据层
 * 
 * @author huayi
 */
public interface SysUserRoleMapper
{
    /**
     * 通过用户ID删除用户和角色关联
     * 
     * @param condition
     * @return 结果
     */
    public int deleteUserRoleByUserId(SysUserRoleCondition condition);

    /**
     * 批量删除用户和角色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserRole(Long[] ids);

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);

    /**
     * 批量新增用户角色信息
     * 
     * @param userRoleList 用户角色列表
     * @return 结果
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    public int deleteUserRoleIn(SysRoleUserUpdateCondition condition);

    public List<SysUserRole> selectUserRoleList(SysRoleUserUpdateCondition condition);
}
