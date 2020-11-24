package com.huayi.system.service;

import java.util.List;
import java.util.Set;

import com.huayi.system.condition.system.SysRoleCondition;
import com.huayi.system.condition.system.SysRoleDeleteCondition;
import com.huayi.system.condition.system.SysRoleMenuCondition;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysUserRole;

/**
 * 角色业务层
 * 
 * @author huayi
 */
public interface ISysRoleService
{
    /**
     * 根据条件分页查询角色数据
     * 
     * @param condition 角色条件
     * @return 角色数据集合信息
     */
    public List<SysRole> selectRoleList(SysRoleCondition condition);

    /**
     * 根据用户ID查询角色
     * 
     * @param condition 查询条件(userId 用户ID）
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(SysRoleCondition condition);

    /**
     * 根据用户ID查询角色
     * 
     * @param condition 查询条件
     * @return 角色列表
     */
    public List<SysRole> selectRolesByUserId(SysRoleCondition condition);

    /**
     * 查询所有角色
     * 
     * @return 角色列表
     */
    public List<SysRole> selectRoleAll(SysRoleCondition condition);

    /**
     * 通过角色ID查询角色
     * 
     * @param condition 查询条件(roleId 角色ID）
     * @return 角色对象信息
     */
    public SysRole selectRoleById(SysRoleCondition condition);

    /**
     * 通过角色ID删除角色
     * 
     * @param condition 查询条件（roleId 角色ID）
     * @return 结果
     */
    public boolean deleteRoleById(SysRoleCondition condition);

    /**
     * 批量删除角色用户信息
     * 
     * @param condition 删除角色信息(roleIds 需要删除的角色ID)
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteRoleByIds(SysRoleDeleteCondition condition) throws Exception;

    /**
     * 新增保存角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int insertRole(SysRole role);

    /**
     * 修改保存角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    public int updateRole(SysRole role);

    /**
     * 修改数据权限信息
     * 
     * @param role 角色条件
     * @return 结果
     */
    public int updateRule(SysRole role);

    /**
     * 校验角色名称是否唯一
     * 
     * @param condition 角色条件
     * @return 结果
     */
    public String checkRoleNameUnique(SysRoleCondition condition);

    /**
     * 校验角色权限是否唯一
     * 
     * @param condition 角色条件
     * @return 结果
     */
    public String checkRoleKeyUnique(SysRoleCondition condition);

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param condition 角色条件(roleId)
     * @return 结果
     */
    public int countUserRoleByRoleId(SysRoleCondition condition);

    /**
     * 角色状态修改
     * 
     * @param role 角色条件
     * @return 结果
     */
    public int changeStatus(SysRole role);

    public int updateRoleByUserId(Long companyId,Long userId,Long[] roleIds);

    public int deleteUserRoleByUserId(Long companyId,Long userId);

    /**
     * 更新用户角色(新增）
     * @param userRoleList
     * @return
     */
    public int batchUserRole(List<SysUserRole> userRoleList);

    /**
     * 更新角色权限菜单
     * @param condition
     * @return
     */
    int updateMenuByRoleId(SysRoleMenuCondition condition);
}
