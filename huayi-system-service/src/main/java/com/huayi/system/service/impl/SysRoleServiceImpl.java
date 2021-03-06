package com.huayi.system.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.huayi.system.condition.system.SysRoleUserUpdateCondition;
import com.huayi.system.condition.system.SysUserRoleCondition;
import com.huayi.system.domain.SysUserRole;
import com.huayi.system.mapper.SysUserRoleMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.common.annotation.DataScope;
import com.huayi.common.constant.UserConstants;
import com.huayi.common.exception.BusinessException;
import com.huayi.common.support.Convert;
import com.huayi.common.utils.StringUtils;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysRoleMenu;
import com.huayi.system.mapper.SysRoleMapper;
import com.huayi.system.mapper.SysRoleMenuMapper;
import com.huayi.system.service.ISysRoleService;

/**
 * 角色 业务层处理
 * 
 * @author huayi
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService
{
    @Autowired
    private SysRoleMapper roleMapper;

    @Autowired
    private SysRoleMenuMapper roleMenuMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;



    /**
     * 根据条件分页查询角色数据
     * 
     * @param role 角色信息
     * @return 角色数据集合信息
     */
    @Override
    @DataScope(tableAlias = "u")
    public List<SysRole> selectRoleList(SysRole role)
    {
        return roleMapper.selectRoleList(role);
    }

    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRoleKeys(Long userId)
    {
        List<SysRole> perms = roleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    @Override
    public List<SysRole> selectRolesByUserId(Long userId)
    {
        List<SysRole> userRoles = roleMapper.selectRolesByUserId(userId);
        List<SysRole> roles = selectRoleAll();
        for (SysRole role : roles)
        {
            for (SysRole userRole : userRoles)
            {
                if (role.getRoleId().longValue() == userRole.getRoleId().longValue())
                {
                    role.setFlag(true);
                    break;
                }
            }
        }
        return roles;
    }

    /**
     * 查询所有角色
     * 
     * @return 角色列表
     */
    @Override
    public List<SysRole> selectRoleAll()
    {
        return selectRoleList(new SysRole());
    }

    /**
     * 通过角色ID查询角色
     * 
     * @param roleId 角色ID
     * @return 角色对象信息
     */
    @Override
    public SysRole selectRoleById(Long roleId)
    {
        return roleMapper.selectRoleById(roleId);
    }

    /**
     * 通过角色ID删除角色
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    @Override
    public boolean deleteRoleById(Long roleId)
    {
        return roleMapper.deleteRoleById(roleId) > 0 ? true : false;
    }

    /**
     * 批量删除角色信息
     * 
     * @param ids 需要删除的数据ID
     * @throws Exception
     */
    @Override
    public int deleteRoleByIds(String ids) throws BusinessException
    {
        Long[] roleIds = Convert.toLongArray(ids);
        for (Long roleId : roleIds)
        {
            SysRole role = selectRoleById(roleId);
            if (countUserRoleByRoleId(roleId) > 0)
            {
                throw new BusinessException(String.format("%1$s已分配,不能删除", role.getRoleName()));
            }
        }
        return roleMapper.deleteRoleByIds(roleIds);
    }

    /**
     * 新增保存角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int insertRole(SysRole role)
    {
        // 新增角色信息
        roleMapper.insertRole(role);
        return insertRoleMenu(role);
    }

    /**
     * 修改保存角色信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int updateRole(SysRole role)
    {
        // 修改角色信息
        roleMapper.updateRole(role);
        // 删除角色与菜单关联
        roleMenuMapper.deleteRoleMenuByRoleId(role.getRoleId());
        return insertRoleMenu(role);
    }

    /**
     * 修改数据权限信息
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int updateRule(SysRole role)
    {
        // 修改角色信息
        return roleMapper.updateRole(role);
    }

    /**
     * 新增角色菜单信息
     * 
     * @param role 角色对象
     */
    public int insertRoleMenu(SysRole role)
    {
        int rows = 1;
        // 新增用户与角色管理
        List<SysRoleMenu> list = new ArrayList<SysRoleMenu>();
        for (Long menuId : role.getMenuIds())
        {
            SysRoleMenu rm = new SysRoleMenu();
            rm.setRoleId(role.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0)
        {
            rows = roleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }


    /**
     * 校验角色名称是否唯一
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleNameUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleNameUnique(role.getRoleName());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.ROLE_NAME_NOT_UNIQUE;
        }
        return UserConstants.ROLE_NAME_UNIQUE;
    }

    /**
     * 校验角色权限是否唯一
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleKeyUnique(SysRole role)
    {
        Long roleId = StringUtils.isNull(role.getRoleId()) ? -1L : role.getRoleId();
        SysRole info = roleMapper.checkRoleKeyUnique(role.getRoleKey());
        if (StringUtils.isNotNull(info) && info.getRoleId().longValue() != roleId.longValue())
        {
            return UserConstants.ROLE_KEY_NOT_UNIQUE;
        }
        return UserConstants.ROLE_KEY_UNIQUE;
    }

    /**
     * 通过角色ID查询角色使用数量
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    @Override
    public int countUserRoleByRoleId(Long roleId)
    {
        return userRoleMapper.countUserRoleByRoleId(roleId);
    }

    /**
     * 角色状态修改
     * 
     * @param role 角色信息
     * @return 结果
     */
    @Override
    public int changeStatus(SysRole role)
    {
        return roleMapper.updateRole(role);
    }

    @Override
    public int updateRoleByUserId(Long companyId, Long userId, Long[] roleIds) {
        if(userId==null) {
            return -1;
        }
        if(roleIds==null || roleIds.length==0) {
            return -1;
        }
        //先查出数据库当前存储的已设置角色列表
        SysRoleUserUpdateCondition condition = new SysRoleUserUpdateCondition();
        condition.setCompanyId(companyId);
        condition.setRoleIds(roleIds);
        condition.setUserId(userId);
        List<SysUserRole> roleList = userRoleMapper.selectUserRoleList(condition);
        //比对角色--存在存储的;不存在的;其他的
        List<Long> notInList = new ArrayList<Long>();//目前数据库存储的角色ID在新列表不存在的,此类要删
        List<Long> inList = new ArrayList<Long>();//存在列表，此类不动

        for(SysUserRole role:roleList) {
            if(ArrayUtils.contains(roleIds,role.getRoleId())) {
                inList.add(role.getRoleId());
            }else {
                notInList.add(role.getRoleId());
            }
            roleIds = ArrayUtils.removeElement(roleIds,role.getRoleId());
        }
        if(notInList.size()>0) {
            Long[] deleteIds = new Long[notInList.size()];
            notInList.toArray(deleteIds);
            condition.setRoleIds(deleteIds);
            userRoleMapper.deleteUserRoleIn(condition);
        }
        if(roleIds.length>0) {
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roleIds) {
                SysUserRole item = new SysUserRole();
                item.setCompanyId(companyId);
                item.setUserId(userId);
                item.setRoleId(roleId);
                item.setCreateTime(LocalDateTime.now());
                list.add(item);
            }
            return userRoleMapper.batchUserRole(list);
        }
        return 0;
    }

    @Override
    public int deleteUserRoleByUserId(Long companyId,Long userId) {
        SysUserRoleCondition condition = new SysUserRoleCondition();
        condition.setCompanyId(companyId);
        condition.setUserId(userId);
        return userRoleMapper.deleteUserRoleByUserId(condition);
    }

    @Override
    public int batchUserRole(List<SysUserRole> userRoleList) {
        return userRoleMapper.batchUserRole(userRoleList);
    }
}
