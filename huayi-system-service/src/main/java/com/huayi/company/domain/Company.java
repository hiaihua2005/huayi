package com.huayi.company.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.huayi.common.base.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 企业表 sys_company
 * 
 * @author huayi
 * @date 2020-08-15
 */
public class Company  extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	

	/** 企业id */
	private Integer companyId;
	/** 企业名称 */
	private String companyName;
	/** 企业logo */
	private String companyLogo;
	/** 企业公告 */
	private String companyNotice;
	/** 企业号 */
	private String macid;
	/** 行业id */
	private Integer industryId;
	/** 企业电话 */
	private String phone;
	/** 招聘电话 */
	private String recruitPhone;
	/** 企业地址 */
	private String companyAddress;
	/** 地址坐标经度 */
	private String companyLng;
	/** 地址坐标纬度 */
	private String companyLat;
	/** 加入企业审核状态0带审核，1审核通过，2拒绝 */
	private Integer auditState;
	/** 审核描述 */
	private String auditRemark;
	/** 源码url */
	private String sourceUrl;
	/** 访问key */
	private String companyKey;
	/** 1、服务（如果为服务则使用默认小程序账号），2、源码 */
	private Integer companyType;
	/** 1正常，2禁用 */
	private Integer companyState;
	/** 1代理商 */
	private Integer isAgent;
	/** 1删除 */
	private Integer isDel;
	/** 代理金额 */
	private BigDecimal agentMoney;
	/** 公司口令（用于创建名片时判断） */
	private String password;
	/** 套餐版本编码 */
	private String editionCode;
	/** 套餐到期时间 */
	private String deadline;
	/** 企业归属代理商公司id */
	private Integer agentCompanyId;

	/** 认证状态(0草稿；2提交或待审核;3审核中;4打回或审核不通过,8审核完成或认证通过) */
	private String verifyStatus;
	/** 认证时间 */
	private Date verifyTime;
	/** 认证资料表ID */
	private String verifyId;

	public void setCompanyId(Integer companyId)
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setCompanyName(String companyName) 
	{
		this.companyName = companyName;
	}

	public String getCompanyName() 
	{
		return companyName;
	}
	public void setCompanyLogo(String companyLogo) 
	{
		this.companyLogo = companyLogo;
	}

	public String getCompanyLogo() 
	{
		return companyLogo;
	}
	public void setCompanyNotice(String companyNotice) 
	{
		this.companyNotice = companyNotice;
	}

	public String getCompanyNotice() 
	{
		return companyNotice;
	}

	public void setMacid(String macid) 
	{
		this.macid = macid;
	}

	public String getMacid() 
	{
		return macid;
	}

	public void setIndustryId(Integer industryId) 
	{
		this.industryId = industryId;
	}

	public Integer getIndustryId() 
	{
		return industryId;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setRecruitPhone(String recruitPhone) 
	{
		this.recruitPhone = recruitPhone;
	}

	public String getRecruitPhone() 
	{
		return recruitPhone;
	}
	public void setCompanyAddress(String companyAddress) 
	{
		this.companyAddress = companyAddress;
	}

	public String getCompanyAddress() 
	{
		return companyAddress;
	}
	public void setCompanyLng(String companyLng) 
	{
		this.companyLng = companyLng;
	}

	public String getCompanyLng() 
	{
		return companyLng;
	}
	public void setCompanyLat(String companyLat) 
	{
		this.companyLat = companyLat;
	}

	public String getCompanyLat() 
	{
		return companyLat;
	}
	public void setAuditState(Integer auditState) 
	{
		this.auditState = auditState;
	}

	public Integer getAuditState() 
	{
		return auditState;
	}
	public void setAuditRemark(String auditRemark) 
	{
		this.auditRemark = auditRemark;
	}

	public String getAuditRemark() 
	{
		return auditRemark;
	}

	public void setSourceUrl(String sourceUrl) 
	{
		this.sourceUrl = sourceUrl;
	}

	public String getSourceUrl() 
	{
		return sourceUrl;
	}
	public void setCompanyKey(String companyKey) 
	{
		this.companyKey = companyKey;
	}

	public String getCompanyKey() 
	{
		return companyKey;
	}
	public void setCompanyType(Integer companyType) 
	{
		this.companyType = companyType;
	}

	public Integer getCompanyType() 
	{
		return companyType;
	}
	public void setCompanyState(Integer companyState) 
	{
		this.companyState = companyState;
	}

	public Integer getCompanyState() 
	{
		return companyState;
	}

	public void setIsAgent(Integer isAgent)
	{
		this.isAgent = isAgent;
	}

	public Integer getIsAgent() 
	{
		return isAgent;
	}
	public void setIsDel(Integer isDel) 
	{
		this.isDel = isDel;
	}

	public Integer getIsDel() 
	{
		return isDel;
	}
	public void setAgentMoney(BigDecimal agentMoney) 
	{
		this.agentMoney = agentMoney;
	}

	public BigDecimal getAgentMoney() 
	{
		return agentMoney;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setEditionCode(String editionCode) 
	{
		this.editionCode = editionCode;
	}

	public String getEditionCode() 
	{
		return editionCode;
	}

	public void setDeadline(String deadline) 
	{
		this.deadline = deadline;
	}

	public String getDeadline() 
	{
		return deadline;
	}
	public void setAgentCompanyId(Integer agentCompanyId) 
	{
		this.agentCompanyId = agentCompanyId;
	}

	public Integer getAgentCompanyId() 
	{
		return agentCompanyId;
	}

	public void setVerifyStatus(String verifyStatus) 
	{
		this.verifyStatus = verifyStatus;
	}

	public String getVerifyStatus() 
	{
		return verifyStatus;
	}
	public void setVerifyTime(Date verifyTime) 
	{
		this.verifyTime = verifyTime;
	}

	public Date getVerifyTime() 
	{
		return verifyTime;
	}
	public void setVerifyId(String verifyId) 
	{
		this.verifyId = verifyId;
	}

	public String getVerifyId() 
	{
		return verifyId;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyLogo", getCompanyLogo())
            .append("companyNotice", getCompanyNotice())
            .append("macid", getMacid())
            .append("industryId", getIndustryId())
            .append("phone", getPhone())
            .append("recruitPhone", getRecruitPhone())
            .append("companyAddress", getCompanyAddress())
            .append("companyLng", getCompanyLng())
            .append("companyLat", getCompanyLat())
            .append("auditState", getAuditState())
            .append("auditRemark", getAuditRemark())
            .append("sourceUrl", getSourceUrl())
            .append("companyKey", getCompanyKey())
            .append("companyType", getCompanyType())
            .append("companyState", getCompanyState())
            .append("createTime", getCreateTime())
			.append("createUserId", getCreateUserId())
            .append("createUserName", getCreateUserName())
            .append("updateTime", getUpdateTime())
            .append("updateUserId", getUpdateUserId())
            .append("updateUserName", getUpdateUserName())
            .append("isAgent", getIsAgent())
            .append("isDel", getIsDel())
            .append("agentMoney", getAgentMoney())
            .append("password", getPassword())
            .append("editionCode", getEditionCode())
            .append("deadline", getDeadline())
            .append("agentCompanyId", getAgentCompanyId())
            .append("verifyStatus", getVerifyStatus())
            .append("verifyTime", getVerifyTime())
            .append("verifyId", getVerifyId())
            .toString();
    }
}
