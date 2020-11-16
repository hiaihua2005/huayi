package com.huayi.system.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 用户表 sys_user
 * 
 * @author huayi
 * @date 2020-08-12
 */
public class SysUser implements Serializable
{
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Long userId;
	/** 企业id */
	private Long companyId;
	/** 部门ID */
	private Long deptId;
	/** 登录账号 */
	private String loginName;
	/** 用户昵称 */
	private String userName;
	/** 用户类型（00系统用户） */
	private String userType;
	/** 电话 */
	private String phone;
	/** 用户邮箱 */
	private String email;
	/** 用户性别（0男 1女 2未知） */
	private String sex;
	/** 头像路径 */
	private String avatar;
	/** 密码 */
	private String password;
	/** 盐加密 */
	private String salt;
	/** 帐号状态（0正常 1停用） */
	private String status;
	/** 最后登陆IP */
	private String loginIp;
	/** 最后登陆时间 */
	private Date loginDate;
	/** 创建者 */
	private String createBy;
	/** 创建时间 */
	private Date createTime;
	/** 部门对象 */
	private SysDept dept;
	/** 角色组 */
	private Long[] roleIds;

	private List<SysRole> roles;
	/** 更新者 */
	private String updateBy;
	/** 更新时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;
	/** 是否删除 **/
	private String isDel;


	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getUserId()
	{
		return userId;
	}
	public void setCompanyId(Long companyId)
	{
		this.companyId = companyId;
	}

	public Long getCompanyId()
	{
		return companyId;
	}

	public void setDeptId(Long deptId)
	{
		this.deptId = deptId;
	}

	public Long getDeptId()
	{
		return deptId;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}

	public String getLoginName() 
	{
		return loginName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}

	public String getUserType() 
	{
		return userType;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setSex(String sex) 
	{
		this.sex = sex;
	}

	public String getSex() 
	{
		return sex;
	}
	public void setAvatar(String avatar) 
	{
		this.avatar = avatar;
	}

	public String getAvatar() 
	{
		return avatar;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setSalt(String salt) 
	{
		this.salt = salt;
	}

	public String getSalt() 
	{
		return salt;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

	public void setLoginIp(String loginIp) 
	{
		this.loginIp = loginIp;
	}

	public String getLoginIp() 
	{
		return loginIp;
	}

	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}



	public Long[] getRoleIds()
	{
		return roleIds;
	}

	public void setRoleIds(Long[] roleIds)
	{
		this.roleIds = roleIds;
	}

	public static boolean isSuperAdmin(Long userId)
	{
		return userId != null && (1L == userId || 0L == userId);
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	@Override
	public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("companyId", getCompanyId())
            .append("deptId", getDeptId())
            .append("loginName", getLoginName())
            .append("userName", getUserName())
            .append("userType", getUserType())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("status", getStatus())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
