package com.huayi.system.mapper;

import java.util.List;

import com.huayi.system.condition.system.SysRoleCondition;
import com.huayi.system.condition.system.SysRoleDeleteCondition;
import com.huayi.system.domain.SysRole;

/**
 * 角色表 数据层
 * 
 * @author huayi
 */
public interface SysRoleMapper
{
    /**
     * 根据条件分页查询角色数据
     * 
     * @param condition 角色信息
     * @return 角色数据集合信息
     */
    public List<SysRole> selectRoleList(SysRoleCondition condition);

    /**
     * 根据用户ID查询角色
     * 
     * @param condition 查询条件(companyId,userId)
     * @return 角色列表
     */
    public List<SysRole> selectRolesByUserId(SysRoleCondition condition);

    /**
     * 通过角色ID查询角色
     * 
     * @param condition 查询条件(companyId,roleId)
     * @return 角色对象信息
     */
    public SysRole selectRoleById(SysRoleCondition condition);

    /**
     * 通过角色ID删除角色
     * 
     * @param condition 查询条件(companyId,roleId)
     * @return 结果
     */
    public int deleteRoleById(SysRoleCondition condition);

    /**
     * 批量角色用户信息
     * 
     * @param condition 删除条件(roleIds 需要删除的数据ID)
     * @return 结果
     */
    public int deleteRoleByIds(SysRoleDeleteCondition condition);

    /**
     * 修改角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int updateRole(SysRole role);

    /**
     * 新增角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    /**
     * 校验角色名称是否唯一
     * 
     * @param condition (roleName 角色名称)
     * @return 角色信息
     */
    public SysRole checkRoleNameUnique(SysRoleCondition condition);
    
    /**
     * 校验角色权限是否唯一
     * 
     * @param condition (roleKey 角色权限)
     * @return 角色信息
     */
    public SysRole checkRoleKeyUnique(SysRoleCondition condition);
}
