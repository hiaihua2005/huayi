package com.huayi.company.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 企业商户商城申请（商城与公司对应）表 t_company_mall_apply
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyApply implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 主键id */
	private Integer recordId;
	/** 企业id */
	private Integer companyId;
	/** 门店id */
	private Integer shopId;
	/** 门店logo */
	private String shopLogo;
	/** 商户唯一编号 */
	private String macid;
	/** 商城名称 */
	private String mallName;
	/** 商城摘要 */
	private String mallRemark;
	/** 用户名 */
	private String userName;
	/** 登录密码 */
	private String password;
	/** 0申请中1创建成功2拒绝 */
	private Integer status;
	/** 是否删除 */
	private Integer isDelete;
	/** 商城小程序id */
	private Integer wxappId;
	/** 审核员ID */
	private Integer adminId;
	/** 截止时间 */
	private Integer endingTime;
	/** 创建时间 */
	private Integer createTime;
	/** 更新时间 */
	private Integer updateTime;

	public void setRecordId(Integer recordId) 
	{
		this.recordId = recordId;
	}

	public Integer getRecordId() 
	{
		return recordId;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setShopId(Integer shopId) 
	{
		this.shopId = shopId;
	}

	public Integer getShopId() 
	{
		return shopId;
	}
	public void setShopLogo(String shopLogo) 
	{
		this.shopLogo = shopLogo;
	}

	public String getShopLogo() 
	{
		return shopLogo;
	}
	public void setMacid(String macid) 
	{
		this.macid = macid;
	}

	public String getMacid() 
	{
		return macid;
	}
	public void setMallName(String mallName) 
	{
		this.mallName = mallName;
	}

	public String getMallName() 
	{
		return mallName;
	}
	public void setMallRemark(String mallRemark) 
	{
		this.mallRemark = mallRemark;
	}

	public String getMallRemark() 
	{
		return mallRemark;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getPassword() 
	{
		return password;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}
	public void setIsDelete(Integer isDelete) 
	{
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() 
	{
		return isDelete;
	}
	public void setWxappId(Integer wxappId) 
	{
		this.wxappId = wxappId;
	}

	public Integer getWxappId() 
	{
		return wxappId;
	}
	public void setAdminId(Integer adminId) 
	{
		this.adminId = adminId;
	}

	public Integer getAdminId() 
	{
		return adminId;
	}
	public void setEndingTime(Integer endingTime) 
	{
		this.endingTime = endingTime;
	}

	public Integer getEndingTime() 
	{
		return endingTime;
	}
	public void setCreateTime(Integer createTime) 
	{
		this.createTime = createTime;
	}

	public Integer getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Integer updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Integer getUpdateTime() 
	{
		return updateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("companyId", getCompanyId())
            .append("shopId", getShopId())
            .append("shopLogo", getShopLogo())
            .append("macid", getMacid())
            .append("mallName", getMallName())
            .append("mallRemark", getMallRemark())
            .append("userName", getUserName())
            .append("password", getPassword())
            .append("status", getStatus())
            .append("isDelete", getIsDelete())
            .append("wxappId", getWxappId())
            .append("adminId", getAdminId())
            .append("endingTime", getEndingTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
