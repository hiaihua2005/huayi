package com.huayi.scrm.domain;

import java.util.Date;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 客户表 t_customer
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class Customer implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 客户id */
	private Integer customerId;
	/** 客户用户id */
	private Integer userId;
	/** 客户名片id */
	private Integer cardId;
	/** 客户名 */
	private String customerName;
	/** 备注名 */
	private String remarkName;
	/** 性别(1男，2女) */
	private Integer gender;
	/** 生日 */
	private String birthday;
	/** 微信号 */
	private String wxCode;
	/** 邮箱 */
	private String email;
	/** 备注 */
	private String remark;
	/** 客户联系电话 */
	private String customerPhone;
	/** 客户联系地址 */
	private String customerAddress;
	/** 客户公司 */
	private String customerCompanyName;
	/** 客户职位 */
	private String customerTitle;
	/** 客户头像 */
	private String customerLogo;
	/** 客户来源类型编号1~29 */
	private Integer sourceTypeId;
	/** 客户来源编号 */
	private Integer sourceRecordId;
	/** 客户归属那个员工Id */
	private Integer ascriptionId;
	/** 1:独占客户，
2:共享客户 */
	private Integer customerState;
	/** 总成交金额 */
	private Integer turnoverAmount;
	/** 备注 */
	private String customerRemark;
	/** 客户关系属于公司id */
	private Integer companyId;
	/** 首席客户经理 */
	private Integer firstStaffId;
	/** 当前客户经理 */
	private Integer staffId;
	/** 最后跟进时间 */
	private Integer lastFollowTime;
	/** 创建时间 */
	private Date createTime;
	/** 1删除 */
	private Integer isDel;
	/** 客户最新独占时间 */
	private Date exclusiveUpdateTime;

	public void setCustomerId(Integer customerId) 
	{
		this.customerId = customerId;
	}

	public Integer getCustomerId() 
	{
		return customerId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setCardId(Integer cardId) 
	{
		this.cardId = cardId;
	}

	public Integer getCardId() 
	{
		return cardId;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	public String getCustomerName() 
	{
		return customerName;
	}
	public void setRemarkName(String remarkName) 
	{
		this.remarkName = remarkName;
	}

	public String getRemarkName() 
	{
		return remarkName;
	}
	public void setGender(Integer gender) 
	{
		this.gender = gender;
	}

	public Integer getGender() 
	{
		return gender;
	}
	public void setBirthday(String birthday) 
	{
		this.birthday = birthday;
	}

	public String getBirthday() 
	{
		return birthday;
	}
	public void setWxCode(String wxCode) 
	{
		this.wxCode = wxCode;
	}

	public String getWxCode() 
	{
		return wxCode;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setCustomerPhone(String customerPhone) 
	{
		this.customerPhone = customerPhone;
	}

	public String getCustomerPhone() 
	{
		return customerPhone;
	}
	public void setCustomerAddress(String customerAddress) 
	{
		this.customerAddress = customerAddress;
	}

	public String getCustomerAddress() 
	{
		return customerAddress;
	}
	public void setCustomerCompanyName(String customerCompanyName) 
	{
		this.customerCompanyName = customerCompanyName;
	}

	public String getCustomerCompanyName() 
	{
		return customerCompanyName;
	}
	public void setCustomerTitle(String customerTitle) 
	{
		this.customerTitle = customerTitle;
	}

	public String getCustomerTitle() 
	{
		return customerTitle;
	}
	public void setCustomerLogo(String customerLogo) 
	{
		this.customerLogo = customerLogo;
	}

	public String getCustomerLogo() 
	{
		return customerLogo;
	}
	public void setSourceTypeId(Integer sourceTypeId) 
	{
		this.sourceTypeId = sourceTypeId;
	}

	public Integer getSourceTypeId() 
	{
		return sourceTypeId;
	}
	public void setSourceRecordId(Integer sourceRecordId) 
	{
		this.sourceRecordId = sourceRecordId;
	}

	public Integer getSourceRecordId() 
	{
		return sourceRecordId;
	}
	public void setAscriptionId(Integer ascriptionId) 
	{
		this.ascriptionId = ascriptionId;
	}

	public Integer getAscriptionId() 
	{
		return ascriptionId;
	}
	public void setCustomerState(Integer customerState) 
	{
		this.customerState = customerState;
	}

	public Integer getCustomerState() 
	{
		return customerState;
	}
	public void setTurnoverAmount(Integer turnoverAmount) 
	{
		this.turnoverAmount = turnoverAmount;
	}

	public Integer getTurnoverAmount() 
	{
		return turnoverAmount;
	}
	public void setCustomerRemark(String customerRemark) 
	{
		this.customerRemark = customerRemark;
	}

	public String getCustomerRemark() 
	{
		return customerRemark;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setFirstStaffId(Integer firstStaffId) 
	{
		this.firstStaffId = firstStaffId;
	}

	public Integer getFirstStaffId() 
	{
		return firstStaffId;
	}
	public void setStaffId(Integer staffId) 
	{
		this.staffId = staffId;
	}

	public Integer getStaffId() 
	{
		return staffId;
	}
	public void setLastFollowTime(Integer lastFollowTime) 
	{
		this.lastFollowTime = lastFollowTime;
	}

	public Integer getLastFollowTime() 
	{
		return lastFollowTime;
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
	public void setExclusiveUpdateTime(Date exclusiveUpdateTime) 
	{
		this.exclusiveUpdateTime = exclusiveUpdateTime;
	}

	public Date getExclusiveUpdateTime() 
	{
		return exclusiveUpdateTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customerId", getCustomerId())
            .append("userId", getUserId())
            .append("cardId", getCardId())
            .append("customerName", getCustomerName())
            .append("remarkName", getRemarkName())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("wxCode", getWxCode())
            .append("email", getEmail())
            .append("remark", getRemark())
            .append("customerPhone", getCustomerPhone())
            .append("customerAddress", getCustomerAddress())
            .append("customerCompanyName", getCustomerCompanyName())
            .append("customerTitle", getCustomerTitle())
            .append("customerLogo", getCustomerLogo())
            .append("sourceTypeId", getSourceTypeId())
            .append("sourceRecordId", getSourceRecordId())
            .append("ascriptionId", getAscriptionId())
            .append("customerState", getCustomerState())
            .append("turnoverAmount", getTurnoverAmount())
            .append("customerRemark", getCustomerRemark())
            .append("companyId", getCompanyId())
            .append("firstStaffId", getFirstStaffId())
            .append("staffId", getStaffId())
            .append("lastFollowTime", getLastFollowTime())
            .append("createTime", getCreateTime())
            .append("isDel", getIsDel())
            .append("exclusiveUpdateTime", getExclusiveUpdateTime())
            .toString();
    }
}
