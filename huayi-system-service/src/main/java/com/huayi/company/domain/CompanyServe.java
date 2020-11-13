package com.huayi.company.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 企业账号服务表 t_company_serve
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyServe implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 记录 */
	private Integer recordId;
	/** 企业id */
	private Integer companyId;
	/** 产品编码 */
	private Integer mpId;
	/** 产品代码 */
	private String mpCode;
	/** 产品名称 */
	private String mpName;
	/**  */
	private String mpGroup;
	/** 产品类型 */
	private String mpType;
	/** 商户数 */
	private String merchant;
	/** 名片数 */
	private String card;
	/** 存储容量 */
	private String storage;
	/** 流量限制 */
	private String traffic;
	/** 门店数 */
	private String store;
	/** 申请时间 */
	private Integer applyTime;
	/** 到期时间 */
	private Integer endingTime;
	/** 1删除 */
	private Integer isDel;
	/** 订单号 */
	private String orderNo;
	/** 支付金额 */
	private BigDecimal orderPrice;
	/**  */
	private String editionCode;
	/** 创建时间 */
	private Date createTime;
	/** 到期日期 */
	private String deadline;

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
	public void setMpId(Integer mpId) 
	{
		this.mpId = mpId;
	}

	public Integer getMpId() 
	{
		return mpId;
	}
	public void setMpCode(String mpCode) 
	{
		this.mpCode = mpCode;
	}

	public String getMpCode() 
	{
		return mpCode;
	}
	public void setMpName(String mpName) 
	{
		this.mpName = mpName;
	}

	public String getMpName() 
	{
		return mpName;
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
	public void setApplyTime(Integer applyTime) 
	{
		this.applyTime = applyTime;
	}

	public Integer getApplyTime() 
	{
		return applyTime;
	}
	public void setEndingTime(Integer endingTime) 
	{
		this.endingTime = endingTime;
	}

	public Integer getEndingTime() 
	{
		return endingTime;
	}
	public void setIsDel(Integer isDel) 
	{
		this.isDel = isDel;
	}

	public Integer getIsDel() 
	{
		return isDel;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setOrderPrice(BigDecimal orderPrice) 
	{
		this.orderPrice = orderPrice;
	}

	public BigDecimal getOrderPrice() 
	{
		return orderPrice;
	}
	public void setEditionCode(String editionCode) 
	{
		this.editionCode = editionCode;
	}

	public String getEditionCode() 
	{
		return editionCode;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setDeadline(String deadline) 
	{
		this.deadline = deadline;
	}

	public String getDeadline() 
	{
		return deadline;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("companyId", getCompanyId())
            .append("mpId", getMpId())
            .append("mpCode", getMpCode())
            .append("mpName", getMpName())
            .append("mpGroup", getMpGroup())
            .append("mpType", getMpType())
            .append("merchant", getMerchant())
            .append("card", getCard())
            .append("storage", getStorage())
            .append("traffic", getTraffic())
            .append("store", getStore())
            .append("applyTime", getApplyTime())
            .append("endingTime", getEndingTime())
            .append("isDel", getIsDel())
            .append("orderNo", getOrderNo())
            .append("orderPrice", getOrderPrice())
            .append("editionCode", getEditionCode())
            .append("createTime", getCreateTime())
            .append("deadline", getDeadline())
            .toString();
    }
}
