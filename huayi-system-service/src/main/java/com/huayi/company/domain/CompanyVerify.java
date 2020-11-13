package com.huayi.company.domain;

import java.util.Date;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 企业认证表 t_company_verify
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyVerify implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 认证资料ID */
	private Integer verifyId;
	/** 门户id(company_id即为门户ID) */
	private Integer companyId;
	/**  */
	private String companyName;
	/** 公司法人项目 */
	private String companyLegalName;
	/** 法人身份证号 */
	private String companyLegalIden;
	/** 公司营业执照 */
	private String companyOrgCert;
	/** 公司机构号 */
	private String companyOrgCode;
	/** 公司授权书 */
	private String companyAuth;
	/** 上传人ID */
	private Integer companyUserId;
	/** 上传人姓名 */
	private String companyUserName;
	/** 上传人证件号 */
	private String companyUserIden;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 认证状态(0草稿；2提交或待审核;3审核中;4打回或审核不通过,8审核完成或认证通过) */
	private String verifyStatus;
	/** 审核人编码 */
	private Integer verifyUserId;
	/** 审核人姓名 */
	private String verifyUserName;
	/** 审核时间 */
	private Date verifyTime;
	/** 审核备注 */
	private String verifyRemark;

	public void setVerifyId(Integer verifyId) 
	{
		this.verifyId = verifyId;
	}

	public Integer getVerifyId() 
	{
		return verifyId;
	}
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
	public void setCompanyLegalName(String companyLegalName) 
	{
		this.companyLegalName = companyLegalName;
	}

	public String getCompanyLegalName() 
	{
		return companyLegalName;
	}
	public void setCompanyLegalIden(String companyLegalIden) 
	{
		this.companyLegalIden = companyLegalIden;
	}

	public String getCompanyLegalIden() 
	{
		return companyLegalIden;
	}
	public void setCompanyOrgCert(String companyOrgCert) 
	{
		this.companyOrgCert = companyOrgCert;
	}

	public String getCompanyOrgCert() 
	{
		return companyOrgCert;
	}
	public void setCompanyOrgCode(String companyOrgCode) 
	{
		this.companyOrgCode = companyOrgCode;
	}

	public String getCompanyOrgCode() 
	{
		return companyOrgCode;
	}
	public void setCompanyAuth(String companyAuth) 
	{
		this.companyAuth = companyAuth;
	}

	public String getCompanyAuth() 
	{
		return companyAuth;
	}
	public void setCompanyUserId(Integer companyUserId) 
	{
		this.companyUserId = companyUserId;
	}

	public Integer getCompanyUserId() 
	{
		return companyUserId;
	}
	public void setCompanyUserName(String companyUserName) 
	{
		this.companyUserName = companyUserName;
	}

	public String getCompanyUserName() 
	{
		return companyUserName;
	}
	public void setCompanyUserIden(String companyUserIden) 
	{
		this.companyUserIden = companyUserIden;
	}

	public String getCompanyUserIden() 
	{
		return companyUserIden;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setVerifyStatus(String verifyStatus) 
	{
		this.verifyStatus = verifyStatus;
	}

	public String getVerifyStatus() 
	{
		return verifyStatus;
	}
	public void setVerifyUserId(Integer verifyUserId) 
	{
		this.verifyUserId = verifyUserId;
	}

	public Integer getVerifyUserId() 
	{
		return verifyUserId;
	}
	public void setVerifyUserName(String verifyUserName) 
	{
		this.verifyUserName = verifyUserName;
	}

	public String getVerifyUserName() 
	{
		return verifyUserName;
	}
	public void setVerifyTime(Date verifyTime) 
	{
		this.verifyTime = verifyTime;
	}

	public Date getVerifyTime() 
	{
		return verifyTime;
	}
	public void setVerifyRemark(String verifyRemark) 
	{
		this.verifyRemark = verifyRemark;
	}

	public String getVerifyRemark() 
	{
		return verifyRemark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("verifyId", getVerifyId())
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyLegalName", getCompanyLegalName())
            .append("companyLegalIden", getCompanyLegalIden())
            .append("companyOrgCert", getCompanyOrgCert())
            .append("companyOrgCode", getCompanyOrgCode())
            .append("companyAuth", getCompanyAuth())
            .append("companyUserId", getCompanyUserId())
            .append("companyUserName", getCompanyUserName())
            .append("companyUserIden", getCompanyUserIden())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("verifyStatus", getVerifyStatus())
            .append("verifyUserId", getVerifyUserId())
            .append("verifyUserName", getVerifyUserName())
            .append("verifyTime", getVerifyTime())
            .append("verifyRemark", getVerifyRemark())
            .toString();
    }
}
