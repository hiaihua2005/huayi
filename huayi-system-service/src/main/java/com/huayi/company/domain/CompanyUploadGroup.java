package com.huayi.company.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 资源分组记录表 t_company_upload_group
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyUploadGroup implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 分类id */
	private Integer groupId;
	/** 文件类型 */
	private String groupType;
	/** 分类名称 */
	private String groupName;
	/** 文件数量 */
	private Integer fileNums;
	/** 父级 */
	private Integer parentId;
	/** 企业id */
	private Integer companyId;
	/** 分类排序(数字越小越靠前) */
	private Integer sort;
	/** 是否删除 */
	private Integer isDelete;
	/** 商户号 */
	private String macid;
	/** 创建时间 */
	private Integer createTime;
	/** 更新时间 */
	private Integer updateTime;

	public void setGroupId(Integer groupId) 
	{
		this.groupId = groupId;
	}

	public Integer getGroupId() 
	{
		return groupId;
	}
	public void setGroupType(String groupType) 
	{
		this.groupType = groupType;
	}

	public String getGroupType() 
	{
		return groupType;
	}
	public void setGroupName(String groupName) 
	{
		this.groupName = groupName;
	}

	public String getGroupName() 
	{
		return groupName;
	}
	public void setFileNums(Integer fileNums) 
	{
		this.fileNums = fileNums;
	}

	public Integer getFileNums() 
	{
		return fileNums;
	}
	public void setParentId(Integer parentId) 
	{
		this.parentId = parentId;
	}

	public Integer getParentId() 
	{
		return parentId;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setSort(Integer sort) 
	{
		this.sort = sort;
	}

	public Integer getSort() 
	{
		return sort;
	}
	public void setIsDelete(Integer isDelete) 
	{
		this.isDelete = isDelete;
	}

	public Integer getIsDelete() 
	{
		return isDelete;
	}
	public void setMacid(String macid) 
	{
		this.macid = macid;
	}

	public String getMacid() 
	{
		return macid;
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
            .append("groupId", getGroupId())
            .append("groupType", getGroupType())
            .append("groupName", getGroupName())
            .append("fileNums", getFileNums())
            .append("parentId", getParentId())
            .append("companyId", getCompanyId())
            .append("sort", getSort())
            .append("isDelete", getIsDelete())
            .append("macid", getMacid())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
