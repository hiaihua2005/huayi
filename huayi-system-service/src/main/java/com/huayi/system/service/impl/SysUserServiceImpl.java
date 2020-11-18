package com.huayi.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.huayi.system.condition.system.SysUserBatchDeleteCondition;
import com.huayi.system.condition.system.SysUserCondition;
import com.huayi.system.service.ISysRoleService;
import io.jsonwebtoken.lang.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.common.annotation.DataScope;
import com.huayi.common.constant.UserConstants;
import com.huayi.common.exception.BusinessException;
import com.huayi.common.support.Convert;
import com.huayi.common.utils.Md5Utils;
import com.huayi.common.utils.StringUtils;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysUser;
import com.huayi.system.domain.SysUserRole;
import com.huayi.system.mapper.SysRoleMapper;
import com.huayi.system.mapper.SysUserMapper;
import com.huayi.system.mapper.SysUserRoleMapper;
import com.huayi.system.service.ISysUserService;

/**
 * 用户 业务层处理
 * 
 * @author huayi
 */
@Service(value = "sysUserService")
public class SysUserServiceImpl implements ISysUserService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;



    @Autowired
    private ISysRoleService roleService;


    /**
     * 根据条件分页查询用户对象
     * 
     * @param user 用户信息
     * 
     * @return 用户信息集合信息
     */
    @Override
    @DataScope(tableAlias = "u")
    public List<SysUser> selectUserList(SysUser user)
    {
        if(user ==null || user.getCompanyId()==null) {
            return null;
        }
        return userMapper.selectUserList(user);
    }

    /**
     * 通过用户名查询用户
     *
     * @param loginName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByLoginName(String loginName)
    {
        return userMapper.selectUserByLoginName(loginName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param companyId 公司ID
     * @param phone 手机号码
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByPhone(Long companyId,String phone)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(companyId);
        condition.setPhone(phone);
        return userMapper.selectUserByPhone(condition);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param companyId 公司ID
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByEmail(Long companyId,String email)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(companyId);
        condition.setEmail(email);
        return userMapper.selectUserByEmail(condition);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param phone 手机号码
     * @return 用户对象信息
     */
    @Override
    public List<SysUser> selectUserByPhone(String phone)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setPhone(phone);
        return userMapper.selectUserListByPhone(condition);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public List<SysUser> selectUserByEmail(String email)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setEmail(email);
        return userMapper.selectUserListByEmail(condition);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param companyId 公司ID
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long companyId,Long userId)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(companyId);
        condition.setUserId(userId);
        return userMapper.selectUserById(condition);
    }

    /**
     * 通过用户ID删除用户
     *
     * @param companyId 公司ID
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public int deleteUserById(Long companyId,Long userId)
    {
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(companyId);
        condition.setUserId(userId);
        // 删除用户与角色关联
        roleService.deleteUserRoleByUserId(companyId,userId);
        return userMapper.deleteUserById(condition);
    }

    /**
     * 批量删除用户信息
     *
     * @param companyId 公司ID
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserByIds(Long companyId,String ids) throws BusinessException
    {
        Long[] userIds = Convert.toLongArray(ids);
        for (Long userId : userIds)
        {
            if (SysUser.isSuperAdmin(userId))
            {
                throw new BusinessException("不允许删除超级管理员用户");
            }
        }
        SysUserBatchDeleteCondition condition = new SysUserBatchDeleteCondition();
        condition.setCompanyId(companyId);
        condition.setUserId(Strings.split(ids,","));
        return userMapper.deleteUserByIds(condition);
    }

    /**
     * 新增保存用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int insertUser(SysUser user)
    {
        // 新增用户信息
        int rows = userMapper.insertUser(user);
        // 新增用户与角色管理
        insertUserRole(user);
        return rows;
    }

    /**
     * 修改保存用户信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUser(SysUser user)
    {
        //更新用户角色关系
        roleService.updateRoleByUserId(user.getCompanyId(),user.getUserId(),user.getRoleIds());
        return userMapper.updateUser(user);
    }

    /**
     * 新增用户角色信息
     *
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user)
    {
        Long[] roles = user.getRoleIds();
        if (StringUtils.isNotNull(roles))
        {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roles)
            {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(user.getUserId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0)
            {
                roleService.batchUserRole(list);
            }
        }
    }

    /**
     * 修改用户个人详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户密码
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetUserPwd(SysUser user)
    {
        return updateUserInfo(user);
    }


    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 用户名
     * @return
     */
    @Override
    public String checkLoginNameUnique(String loginName)
    {
        int count = userMapper.checkLoginNameUnique(loginName);
        if (count > 0)
        {
            return UserConstants.USER_NAME_NOT_UNIQUE;
        }
        return UserConstants.USER_NAME_UNIQUE;
    }

    /**
     * 校验用户名称是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkPhoneUnique(SysUser user)
    {
        if(user.getCompanyId()==null || user.getCompanyId().longValue()<=0) {
            return UserConstants.USER_PHONE_NO_PARAM;
        }
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(user.getCompanyId());
        condition.setPhone(user.getPhone());
        SysUser info = userMapper.checkPhoneUnique(condition);
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_PHONE_NOT_UNIQUE;
        }
        return UserConstants.USER_PHONE_UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public String checkEmailUnique(SysUser user)
    {
        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
        SysUserCondition condition = new SysUserCondition();
        condition.setCompanyId(user.getCompanyId());
        condition.setPhone(user.getEmail());
        SysUser info = userMapper.checkEmailUnique(condition);
        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
        {
            return UserConstants.USER_EMAIL_NOT_UNIQUE;
        }
        return UserConstants.USER_EMAIL_UNIQUE;
    }

    /**
     * 查询用户所属角色组
     *
     * @param  companyId 公司ID
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    public String selectUserRoleGroup(Long companyId,Long userId)
    {
        List<SysRole> list = roleMapper.selectRolesByUserId(userId);
        StringBuffer idsStr = new StringBuffer();
        for (SysRole role : list)
        {
            idsStr.append(role.getRoleName()).append(",");
        }
        if (StringUtils.isNotEmpty(idsStr.toString()))
        {
            return idsStr.substring(0, idsStr.length() - 1);
        }
        return idsStr.toString();
    }


    /**
     * 导入用户数据
     * 
     * @param userList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importUser(Long companyId,List<SysUser> userList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(userList) || userList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        String password = "999999";
        for (SysUser user : userList)
        {
            try
            {
                // 验证是否存在这个用户
                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
                if (StringUtils.isNull(u))
                {
                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
                    user.setCreateBy(operName);
                    this.insertUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    user.setUpdateBy(operName);
                    this.updateUser(user);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getLoginName() + " 已存在");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + user.getLoginName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

    /**
     * 用户状态修改
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int changeStatus(SysUser user)
    {
        if (SysUser.isSuperAdmin(user.getUserId()))
        {
            throw new BusinessException("不允许修改超级管理员用户");
        }
        return userMapper.updateUser(user);
    }
}
