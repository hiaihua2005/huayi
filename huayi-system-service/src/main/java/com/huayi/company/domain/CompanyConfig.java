package com.huayi.company.domain;

import java.util.Date;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 企管后台配置表 t_company_configs
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyConfig implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 企业id */
	private Integer companyId;
	/** 配置名称 */
	private String name;
	/** 相关配置key-value */
	private String key;
	/** 相关配置key-value */
	private String value;
	/** 1可用 */
	private Integer state;
	/** 创建人id */
	private Integer createUserId;
	/** 创建人 */
	private String createName;
	/** 创建时间 */
	private Date createTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
	public void setKey(String key) 
	{
		this.key = key;
	}

	public String getKey() 
	{
		return key;
	}
	public void setValue(String value) 
	{
		this.value = value;
	}

	public String getValue() 
	{
		return value;
	}
	public void setState(Integer state) 
	{
		this.state = state;
	}

	public Integer getState() 
	{
		return state;
	}
	public void setCreateUserId(Integer createUserId) 
	{
		this.createUserId = createUserId;
	}

	public Integer getCreateUserId() 
	{
		return createUserId;
	}
	public void setCreateName(String createName) 
	{
		this.createName = createName;
	}

	public String getCreateName() 
	{
		return createName;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("companyId", getCompanyId())
            .append("name", getName())
            .append("key", getKey())
            .append("value", getValue())
            .append("state", getState())
            .append("createUserId", getCreateUserId())
            .append("createName", getCreateName())
            .append("createTime", getCreateTime())
            .toString();
    }
}
