package com.huayi.system.mapper;

import java.util.List;

import com.huayi.system.condition.system.SysUserBatchDeleteCondition;
import com.huayi.system.condition.system.SysUserCondition;
import com.huayi.system.domain.SysUser;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface SysUserMapper
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param sysUser 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser sysUser);

    /**
     * 通过手机号码查询用户
     * 
     * @param condition 查询条件
     */
    public SysUser selectUserByPhone(SysUserCondition condition);

    /**
     * 通过邮箱查询用户
     *
     * @param condition 查询条件
     */
    public SysUser selectUserByEmail(SysUserCondition condition);

    /**
     * 通过手机号码查询用户
     *
     * @param condition 查询条件
     */
    public List<SysUser> selectUserListByPhone(SysUserCondition condition);

    /**
     * 通过邮箱查询用户
     *
     * @param condition 查询条件
     */
    public List<SysUser> selectUserListByEmail(SysUserCondition condition);

    /**
     * 通过用户ID查询用户
     *
     * @param condition
     * @return 用户对象信息
     */
    public SysUser selectUserById(SysUserCondition condition);

    /**
     * 通过用户ID删除用户
     *
     * @param condition 查询条件
     * @return 结果
     */
    public int deleteUserById(SysUserCondition condition);

    /**
     * 批量删除用户信息
     *
     * @param condition 删除条件
     * @return 结果
     */
    public int deleteUserByIds(SysUserBatchDeleteCondition condition);

    /**
     * 修改用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 新增用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 校验手机号码是否唯一
     *
     * @param condition 查询条件
     * @return 结果
     */
    public SysUser checkPhoneUnique(SysUserCondition condition);

    /**
     * 校验email是否唯一
     *
     * @param condition 查询条件
     * @return 结果
     */
    public SysUser checkEmailUnique(SysUserCondition condition);


    /**
     * 通过用户名查询用户
     *
     * @param loginName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String loginName);

    /**
     * 校验用户名称是否唯一
     *
     * @param loginName 登录名称
     * @return 结果
     */
    public int checkLoginNameUnique(String loginName);

}
