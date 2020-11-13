package com.huayi.company.domain;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 套餐订购记录表 mp_order
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyOrder implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 订单id */
	private Integer orderId;
	/** 订单号 */
	private String orderNo;
	/** 购买的套餐代号 */
	private String mpCode;
	/** 产品类型(免费free,套餐standard,扩容extension) */
	private String mpType;
	/** 商品总金额(不含优惠折扣) */
	private BigDecimal totalPrice;
	/** 实际订单金额(含优惠折扣) */
	private BigDecimal orderPrice;
	/** 购买数量 */
	private Integer orderNum;
	/** 优惠券id */
	private Integer couponId;
	/** 优惠券抵扣金额 */
	private BigDecimal couponMoney;
	/** 积分抵扣金额 */
	private BigDecimal pointsMoney;
	/** 积分抵扣数量 */
	private Integer pointsNum;
	/** 支付方式(10余额支付 20微信支付) */
	private Integer payType;
	/** 付款状态(10未付款 20已付款) */
	private Integer payStatus;
	/** 付款时间 */
	private Date payTime;
	/** 订单状态(10进行中 20取消 21待取消 30已完成) */
	private Integer orderStatus;
	/** 订单是否已结算(0未结算 1已结算) */
	private Integer isSettled;
	/** 微信支付交易号 */
	private String transactionId;
	/** 支付用户id */
	private Integer userId;
	/** 是否删除 */
	private Integer isDelete;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 折算单价 */
	private BigDecimal orderObversion;
	/** 企业ID */
	private Integer companyId;

	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setMpCode(String mpCode) 
	{
		this.mpCode = mpCode;
	}

	public String getMpCode() 
	{
		return mpCode;
	}
	public void setMpType(String mpType) 
	{
		this.mpType = mpType;
	}

	public String getMpType() 
	{
		return mpType;
	}
	public void setTotalPrice(BigDecimal totalPrice) 
	{
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalPrice() 
	{
		return totalPrice;
	}
	public void setOrderPrice(BigDecimal orderPrice) 
	{
		this.orderPrice = orderPrice;
	}

	public BigDecimal getOrderPrice() 
	{
		return orderPrice;
	}
	public void setOrderNum(Integer orderNum) 
	{
		this.orderNum = orderNum;
	}

	public Integer getOrderNum() 
	{
		return orderNum;
	}
	public void setCouponId(Integer couponId) 
	{
		this.couponId = couponId;
	}

	public Integer getCouponId() 
	{
		return couponId;
	}
	public void setCouponMoney(BigDecimal couponMoney) 
	{
		this.couponMoney = couponMoney;
	}

	public BigDecimal getCouponMoney() 
	{
		return couponMoney;
	}
	public void setPointsMoney(BigDecimal pointsMoney) 
	{
		this.pointsMoney = pointsMoney;
	}

	public BigDecimal getPointsMoney() 
	{
		return pointsMoney;
	}
	public void setPointsNum(Integer pointsNum) 
	{
		this.pointsNum = pointsNum;
	}

	public Integer getPointsNum() 
	{
		return pointsNum;
	}
	public void setPayType(Integer payType) 
	{
		this.payType = payType;
	}

	public Integer getPayType() 
	{
		return payType;
	}
	public void setPayStatus(Integer payStatus) 
	{
		this.payStatus = payStatus;
	}

	public Integer getPayStatus() 
	{
		return payStatus;
	}
	public void setPayTime(Date payTime) 
	{
		this.payTime = payTime;
	}

	public Date getPayTime() 
	{
		return payTime;
	}
	public void setOrderStatus(Integer orderStatus) 
	{
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatus() 
	{
		return orderStatus;
	}
	public void setIsSettled(Integer isSettled) 
	{
		this.isSettled = isSettled;
	}

	public Integer getIsSettled() 
	{
		return isSettled;
	}
	public void setTransactionId(String transactionId) 
	{
		this.transactionId = transactionId;
	}

	public String getTransactionId() 
	{
		return transactionId;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setIsDelete(Integer isDelete) 
	{
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() 
	{
		return isDelete;
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
	public void setOrderObversion(BigDecimal orderObversion) 
	{
		this.orderObversion = orderObversion;
	}

	public BigDecimal getOrderObversion() 
	{
		return orderObversion;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderNo", getOrderNo())
            .append("mpCode", getMpCode())
            .append("mpType", getMpType())
            .append("totalPrice", getTotalPrice())
            .append("orderPrice", getOrderPrice())
            .append("orderNum", getOrderNum())
            .append("couponId", getCouponId())
            .append("couponMoney", getCouponMoney())
            .append("pointsMoney", getPointsMoney())
            .append("pointsNum", getPointsNum())
            .append("payType", getPayType())
            .append("payStatus", getPayStatus())
            .append("payTime", getPayTime())
            .append("orderStatus", getOrderStatus())
            .append("isSettled", getIsSettled())
            .append("transactionId", getTransactionId())
            .append("userId", getUserId())
            .append("isDelete", getIsDelete())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("orderObversion", getOrderObversion())
            .append("companyId", getCompanyId())
            .toString();
    }
}
