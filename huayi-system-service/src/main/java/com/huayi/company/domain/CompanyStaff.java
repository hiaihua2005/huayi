package com.huayi.company.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 企业与员工表 t_company_staff
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyStaff implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 员工id */
	private Integer staffId;
	/** 员工工号 */
	private String jobNumber;
	/** 用户id */
	private Integer userId;
	/** 员工绑定用的商城编号（wxapp_id） */
	private Integer shopId;
	/** 名片id */
	private Integer cardId;
	/** 商户号 */
	private String macid;
	/** 员工名字 */
	private String staffName;
	/** 员工头像 */
	private String staffAvatar;
	/** 用户微信绑定电话 */
	private String phone;
	/** 用户展示电话 */
	private String showPhone;
	/** 隶属企业id */
	private Integer companyId;
	/** 职位 */
	private String title;
	/** 技能专项 */
	private String skills;
	/** 部门 */
	private String deptName;
	/** 部门id */
	private Integer deptId;
	/** 注册来源类型1管理员添加2邀请链接3口令绑定4员工自助申请 */
	private Integer fromType;
	/** 注册来源说明 */
	private String fromRemark;
	/** 排序 */
	private Integer sort;
	/** 入职时间 */
	private Integer joinTime;
	/** 离职时间 */
	private Integer leaveTime;
	/** 0待审核1正常2拒绝 */
	private Integer applyStatus;
	/** 创建时间 */
	private Date createTime;
	/** 1离职 */
	private Integer isDel;

	public void setStaffId(Integer staffId) 
	{
		this.staffId = staffId;
	}

	public Integer getStaffId() 
	{
		return staffId;
	}
	public void setJobNumber(String jobNumber) 
	{
		this.jobNumber = jobNumber;
	}

	public String getJobNumber() 
	{
		return jobNumber;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setShopId(Integer shopId) 
	{
		this.shopId = shopId;
	}

	public Integer getShopId() 
	{
		return shopId;
	}
	public void setCardId(Integer cardId) 
	{
		this.cardId = cardId;
	}

	public Integer getCardId() 
	{
		return cardId;
	}
	public void setMacid(String macid) 
	{
		this.macid = macid;
	}

	public String getMacid() 
	{
		return macid;
	}
	public void setStaffName(String staffName) 
	{
		this.staffName = staffName;
	}

	public String getStaffName() 
	{
		return staffName;
	}
	public void setStaffAvatar(String staffAvatar) 
	{
		this.staffAvatar = staffAvatar;
	}

	public String getStaffAvatar() 
	{
		return staffAvatar;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setShowPhone(String showPhone) 
	{
		this.showPhone = showPhone;
	}

	public String getShowPhone() 
	{
		return showPhone;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getTitle() 
	{
		return title;
	}
	public void setSkills(String skills) 
	{
		this.skills = skills;
	}

	public String getSkills() 
	{
		return skills;
	}
	public void setDeptName(String deptName) 
	{
		this.deptName = deptName;
	}

	public String getDeptName() 
	{
		return deptName;
	}
	public void setDeptId(Integer deptId) 
	{
		this.deptId = deptId;
	}

	public Integer getDeptId() 
	{
		return deptId;
	}
	public void setFromType(Integer fromType) 
	{
		this.fromType = fromType;
	}

	public Integer getFromType() 
	{
		return fromType;
	}
	public void setFromRemark(String fromRemark) 
	{
		this.fromRemark = fromRemark;
	}

	public String getFromRemark() 
	{
		return fromRemark;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setJoinTime(Integer joinTime) 
	{
		this.joinTime = joinTime;
	}

	public Integer getJoinTime() 
	{
		return joinTime;
	}
	public void setLeaveTime(Integer leaveTime) 
	{
		this.leaveTime = leaveTime;
	}

	public Integer getLeaveTime() 
	{
		return leaveTime;
	}
	public void setApplyStatus(Integer applyStatus) 
	{
		this.applyStatus = applyStatus;
	}

	public Integer getApplyStatus() 
	{
		return applyStatus;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setIsDel(Integer isDel) 
	{
		this.isDel = isDel;
	}

	public Integer getIsDel() 
	{
		return isDel;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("staffId", getStaffId())
            .append("jobNumber", getJobNumber())
            .append("userId", getUserId())
            .append("shopId", getShopId())
            .append("cardId", getCardId())
            .append("macid", getMacid())
            .append("staffName", getStaffName())
            .append("staffAvatar", getStaffAvatar())
            .append("phone", getPhone())
            .append("showPhone", getShowPhone())
            .append("companyId", getCompanyId())
            .append("title", getTitle())
            .append("skills", getSkills())
            .append("deptName", getDeptName())
            .append("deptId", getDeptId())
            .append("fromType", getFromType())
            .append("fromRemark", getFromRemark())
            .append("sort", getSort())
            .append("joinTime", getJoinTime())
            .append("leaveTime", getLeaveTime())
            .append("applyStatus", getApplyStatus())
            .append("createTime", getCreateTime())
            .append("isDel", getIsDel())
            .toString();
    }
}
