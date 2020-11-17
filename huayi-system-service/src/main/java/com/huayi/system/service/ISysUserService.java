package com.huayi.system.service;

import java.util.List;
import com.huayi.system.domain.SysUser;

/**
 * 用户 业务层
 * 
 * @author huayi
 */
public interface ISysUserService
{
    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * @return 用户信息集合信息
     */
    public List<SysUser> selectUserList(SysUser user);

    /**
     * 通过用户名查询用户
     *
     * @param loginName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String loginName);

    /**
     * 通过手机号码查询用户
     *
     *
     * @param companyId  公司ID
     * @param phone 手机号码
     * @return 用户对象信息
     */
    public SysUser selectUserByPhone(Long companyId,String phone);

    /**
     * 通过邮箱查询用户
     *
     * @param companyId  公司ID
     * @param email 邮箱
     * @return 用户对象信息
     */
    public SysUser selectUserByEmail(Long companyId,String email);


    /**
     * 通过手机号码查询用户
     *
     *
     * @param phone 手机号码
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByPhone(String phone);

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    public List<SysUser> selectUserByEmail(String email);

    /**
     * 通过用户ID查询用户
     * @param companyId  公司ID
     * @param userId 用户ID
     * @return 用户对象信息
     */
    public SysUser selectUserById(Long companyId,Long userId);

    /**
     * 通过用户ID删除用户
     *
     @ param companyId  公司ID
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserById(Long companyId,Long userId);

    /**
     * 批量删除用户信息
     *
     * @param companyId 公司ID
     * @param ids 需要删除的数据ID
     * @return 结果
     * @throws Exception 异常
     */
    public int deleteUserByIds(Long companyId,String ids) throws Exception;

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int insertUser(SysUser user);

    /**
     * 保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUser(SysUser user);

    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);

    /**
     * 修改用户密码信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int resetUserPwd(SysUser user);

    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);

    /**
     * 根据用户ID查询用户所属角色组
     *
     * @param companyId 公司ID
     * @param userId 用户ID
     * @return 结果
     */
    public String selectUserRoleGroup(Long companyId,Long userId);


    /**
     * 导入用户数据
     *
     * @param companyId 公司ID
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importUser(Long companyId,List<SysUser> userList, Boolean isUpdateSupport, String operName);

    /**
     * 用户状态修改
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int changeStatus(SysUser user);
}
