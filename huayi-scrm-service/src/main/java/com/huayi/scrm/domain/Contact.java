package com.huayi.scrm.domain;

import java.util.Date;
import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

    
/**
 * 人脉关系记录表 t_contacts
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class Contact implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 记录id */
	private Integer recordId;
	/** 商户唯一编号 */
	private String macid;
	/** 公司id */
	private Integer companyId;
	/** 用户的id */
	private Integer userId;
	/** 用户的名片id */
	private Integer cardId;
	/** 好友的userid */
	private Integer friendId;
	/** 好友的cardid */
	private Integer friendCardId;
	/** 好友姓名 */
	private String friendName;
	/** 好友头像 */
	private String friendAvatar;
	/** 好友电话 */
	private String friendPhone;
	/** 0男1女2保密 */
	private Integer friendSex;
	/** 好友公司 */
	private String friendCompany;
	/** 好友职位 */
	private String friendJobTitle;
	/** 好友地址 */
	private String friendAddress;
	/** 1:系统添加，2:手工录入 */
	private Integer fromType;
	/** 关系的类别:客户、老乡、朋友、同学... */
	private String contactClass;
	/** 0:单向好友,1:双向好友,2:对方拉黑 */
	private Integer friendState;
	/** 亲密度1-100 */
	private Integer heart;
	/** 1:删除好友关系 */
	private Integer isDel;
	/** 其他备注 */
	private String remark;
	/** 记录创建时间 */
	private Date createTime;

	public void setRecordId(Integer recordId) 
	{
		this.recordId = recordId;
	}

	public Integer getRecordId() 
	{
		return recordId;
	}
	public void setMacid(String macid) 
	{
		this.macid = macid;
	}

	public String getMacid() 
	{
		return macid;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
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
	public void setFriendId(Integer friendId) 
	{
		this.friendId = friendId;
	}

	public Integer getFriendId() 
	{
		return friendId;
	}
	public void setFriendCardId(Integer friendCardId) 
	{
		this.friendCardId = friendCardId;
	}

	public Integer getFriendCardId() 
	{
		return friendCardId;
	}
	public void setFriendName(String friendName) 
	{
		this.friendName = friendName;
	}

	public String getFriendName() 
	{
		return friendName;
	}
	public void setFriendAvatar(String friendAvatar) 
	{
		this.friendAvatar = friendAvatar;
	}

	public String getFriendAvatar() 
	{
		return friendAvatar;
	}
	public void setFriendPhone(String friendPhone) 
	{
		this.friendPhone = friendPhone;
	}

	public String getFriendPhone() 
	{
		return friendPhone;
	}
	public void setFriendSex(Integer friendSex) 
	{
		this.friendSex = friendSex;
	}

	public Integer getFriendSex() 
	{
		return friendSex;
	}
	public void setFriendCompany(String friendCompany) 
	{
		this.friendCompany = friendCompany;
	}

	public String getFriendCompany() 
	{
		return friendCompany;
	}
	public void setFriendJobTitle(String friendJobTitle) 
	{
		this.friendJobTitle = friendJobTitle;
	}

	public String getFriendJobTitle() 
	{
		return friendJobTitle;
	}
	public void setFriendAddress(String friendAddress) 
	{
		this.friendAddress = friendAddress;
	}

	public String getFriendAddress() 
	{
		return friendAddress;
	}
	public void setFromType(Integer fromType) 
	{
		this.fromType = fromType;
	}

	public Integer getFromType() 
	{
		return fromType;
	}
	public void setContactClass(String contactClass) 
	{
		this.contactClass = contactClass;
	}

	public String getContactClass() 
	{
		return contactClass;
	}
	public void setFriendState(Integer friendState) 
	{
		this.friendState = friendState;
	}

	public Integer getFriendState() 
	{
		return friendState;
	}
	public void setHeart(Integer heart) 
	{
		this.heart = heart;
	}

	public Integer getHeart() 
	{
		return heart;
	}
	public void setIsDel(Integer isDel) 
	{
		this.isDel = isDel;
	}

	public Integer getIsDel() 
	{
		return isDel;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
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
            .append("macid", getMacid())
            .append("companyId", getCompanyId())
            .append("userId", getUserId())
            .append("cardId", getCardId())
            .append("friendId", getFriendId())
            .append("friendCardId", getFriendCardId())
            .append("friendName", getFriendName())
            .append("friendAvatar", getFriendAvatar())
            .append("friendPhone", getFriendPhone())
            .append("friendSex", getFriendSex())
            .append("friendCompany", getFriendCompany())
            .append("friendJobTitle", getFriendJobTitle())
            .append("friendAddress", getFriendAddress())
            .append("fromType", getFromType())
            .append("contactClass", getContactClass())
            .append("friendState", getFriendState())
            .append("heart", getHeart())
            .append("isDel", getIsDel())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .toString();
    }
}
