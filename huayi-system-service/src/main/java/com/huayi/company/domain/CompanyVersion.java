package com.huayi.company.domain;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 小程序套餐表 mp_versions
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyVersion implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer recordId;
	/** 套餐/版本名称 */
	private String mpName;
	/** 版本号 */
	private String mpVersion;
	/** 版本代号 */
	private String mpCode;
	/** 套餐组 */
	private String mpGroup;
	/** 类型 */
	private String mpType;
	/** 是否是主显示套餐,1为主要 */
	private Integer isBasic;
	/** 权限编号 */
	private String moduleIds;
	/** 商户 */
	private String merchant;
	/** 卡片数 */
	private String card;
	/** 存储容量(单位M) */
	private String storage;
	/** 流量限制(单位M) */
	private String traffic;
	/** 门店数 */
	private String store;
	/** 原始价格 */
	private BigDecimal originalPrice;
	/** 实际价格 */
	private BigDecimal price;
	/** 套餐时长 */
	private Integer limitDays;
	/** 等级数字越大越高 */
	private Integer level;
	/** 享受特权 */
	private String privilege;
	/** 说明介绍 */
	private String description;
	/** 是否上线可用1可用 */
	private Integer isPublish;
	/** 创建时间 */
	private Date createTime;

	public void setRecordId(Integer recordId) 
	{
		this.recordId = recordId;
	}

	public Integer getRecordId() 
	{
		return recordId;
	}
	public void setMpName(String mpName) 
	{
		this.mpName = mpName;
	}

	public String getMpName() 
	{
		return mpName;
	}
	public void setMpVersion(String mpVersion) 
	{
		this.mpVersion = mpVersion;
	}

	public String getMpVersion() 
	{
		return mpVersion;
	}
	public void setMpCode(String mpCode) 
	{
		this.mpCode = mpCode;
	}

	public String getMpCode() 
	{
		return mpCode;
	}
	public void setMpGroup(String mpGroup) 
	{
		this.mpGroup = mpGroup;
	}

	public String getMpGroup() 
	{
		return mpGroup;
	}
	public void setMpType(String mpType) 
	{
		this.mpType = mpType;
	}

	public String getMpType() 
	{
		return mpType;
	}
	public void setIsBasic(Integer isBasic) 
	{
		this.isBasic = isBasic;
	}

	public Integer getIsBasic() 
	{
		return isBasic;
	}
	public void setModuleIds(String moduleIds) 
	{
		this.moduleIds = moduleIds;
	}

	public String getModuleIds() 
	{
		return moduleIds;
	}
	public void setMerchant(String merchant) 
	{
		this.merchant = merchant;
	}

	public String getMerchant() 
	{
		return merchant;
	}
	public void setCard(String card) 
	{
		this.card = card;
	}

	public String getCard() 
	{
		return card;
	}
	public void setStorage(String storage) 
	{
		this.storage = storage;
	}

	public String getStorage() 
	{
		return storage;
	}
	public void setTraffic(String traffic) 
	{
		this.traffic = traffic;
	}

	public String getTraffic() 
	{
		return traffic;
	}
	public void setStore(String store) 
	{
		this.store = store;
	}

	public String getStore() 
	{
		return store;
	}
	public void setOriginalPrice(BigDecimal originalPrice) 
	{
		this.originalPrice = originalPrice;
	}

	public BigDecimal getOriginalPrice() 
	{
		return originalPrice;
	}
	public void setPrice(BigDecimal price) 
	{
		this.price = price;
	}

	public BigDecimal getPrice() 
	{
		return price;
	}
	public void setLimitDays(Integer limitDays) 
	{
		this.limitDays = limitDays;
	}

	public Integer getLimitDays() 
	{
		return limitDays;
	}
	public void setLevel(Integer level) 
	{
		this.level = level;
	}

	public Integer getLevel() 
	{
		return level;
	}
	public void setPrivilege(String privilege) 
	{
		this.privilege = privilege;
	}

	public String getPrivilege() 
	{
		return privilege;
	}
	public void setDescription(String description) 
	{
		this.description = description;
	}

	public String getDescription() 
	{
		return description;
	}
	public void setIsPublish(Integer isPublish) 
	{
		this.isPublish = isPublish;
	}

	public Integer getIsPublish() 
	{
		return isPublish;
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
            .append("recordId", getRecordId())
            .append("mpName", getMpName())
            .append("mpVersion", getMpVersion())
            .append("mpCode", getMpCode())
            .append("mpGroup", getMpGroup())
            .append("mpType", getMpType())
            .append("isBasic", getIsBasic())
            .append("moduleIds", getModuleIds())
            .append("merchant", getMerchant())
            .append("card", getCard())
            .append("storage", getStorage())
            .append("traffic", getTraffic())
            .append("store", getStore())
            .append("originalPrice", getOriginalPrice())
            .append("price", getPrice())
            .append("limitDays", getLimitDays())
            .append("level", getLevel())
            .append("privilege", getPrivilege())
            .append("description", getDescription())
            .append("isPublish", getIsPublish())
            .append("createTime", getCreateTime())
            .toString();
    }
}
