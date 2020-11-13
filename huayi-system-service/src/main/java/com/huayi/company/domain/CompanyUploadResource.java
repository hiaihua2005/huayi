package com.huayi.company.domain;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 资源记录表 t_company_upload_resource
 * 
 * @author huayi
 * @date 2020-08-16
 */
public class CompanyUploadResource implements  Serializable
{
	private static final long serialVersionUID = 1L;
	
	/** 资源编号 */
	private String resourceId;
	/** 企业id */
	private Integer companyId;
	/** 存储方式 */
	private String storage;
	/** 文件分组id */
	private Integer groupId;
	/** 文件md5 */
	private String md5;
	/** 是否同步0 未同步 */
	private Integer syncType;
	/** 文件服务器地址 */
	private String fileLocal;
	/** 文件封面 */
	private String fileCovers;
	/** 存储域名 */
	private String fileUrl;
	/** 文件名 */
	private String fileName;
	/** 文件对象名 */
	private String objectName;
	/** 文件大小(字节) */
	private Integer fileSize;
	/** 文件类型1图片2文档3视频 */
	private String fileType;
	/** 文件扩展名 */
	private String extension;
	/** 是否为c端用户上传 */
	private Integer isUser;
	/** 是否已回收 */
	private Integer isRecycle;
	/** 软删除 */
	private Integer isDelete;
	/** 商户号 */
	private String macid;
	/** 创建时间 */
	private Integer createTime;

	public void setResourceId(String resourceId) 
	{
		this.resourceId = resourceId;
	}

	public String getResourceId() 
	{
		return resourceId;
	}
	public void setCompanyId(Integer companyId) 
	{
		this.companyId = companyId;
	}

	public Integer getCompanyId() 
	{
		return companyId;
	}
	public void setStorage(String storage) 
	{
		this.storage = storage;
	}

	public String getStorage() 
	{
		return storage;
	}
	public void setGroupId(Integer groupId) 
	{
		this.groupId = groupId;
	}

	public Integer getGroupId() 
	{
		return groupId;
	}
	public void setMd5(String md5) 
	{
		this.md5 = md5;
	}

	public String getMd5() 
	{
		return md5;
	}
	public void setSyncType(Integer syncType) 
	{
		this.syncType = syncType;
	}

	public Integer getSyncType() 
	{
		return syncType;
	}
	public void setFileLocal(String fileLocal) 
	{
		this.fileLocal = fileLocal;
	}

	public String getFileLocal() 
	{
		return fileLocal;
	}
	public void setFileCovers(String fileCovers) 
	{
		this.fileCovers = fileCovers;
	}

	public String getFileCovers() 
	{
		return fileCovers;
	}
	public void setFileUrl(String fileUrl) 
	{
		this.fileUrl = fileUrl;
	}

	public String getFileUrl() 
	{
		return fileUrl;
	}
	public void setFileName(String fileName) 
	{
		this.fileName = fileName;
	}

	public String getFileName() 
	{
		return fileName;
	}
	public void setObjectName(String objectName) 
	{
		this.objectName = objectName;
	}

	public String getObjectName() 
	{
		return objectName;
	}
	public void setFileSize(Integer fileSize) 
	{
		this.fileSize = fileSize;
	}

	public Integer getFileSize() 
	{
		return fileSize;
	}
	public void setFileType(String fileType) 
	{
		this.fileType = fileType;
	}

	public String getFileType() 
	{
		return fileType;
	}
	public void setExtension(String extension) 
	{
		this.extension = extension;
	}

	public String getExtension() 
	{
		return extension;
	}
	public void setIsUser(Integer isUser) 
	{
		this.isUser = isUser;
	}

	public Integer getIsUser() 
	{
		return isUser;
	}
	public void setIsRecycle(Integer isRecycle) 
	{
		this.isRecycle = isRecycle;
	}

	public Integer getIsRecycle() 
	{
		return isRecycle;
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

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("resourceId", getResourceId())
            .append("companyId", getCompanyId())
            .append("storage", getStorage())
            .append("groupId", getGroupId())
            .append("md5", getMd5())
            .append("syncType", getSyncType())
            .append("fileLocal", getFileLocal())
            .append("fileCovers", getFileCovers())
            .append("fileUrl", getFileUrl())
            .append("fileName", getFileName())
            .append("objectName", getObjectName())
            .append("fileSize", getFileSize())
            .append("fileType", getFileType())
            .append("extension", getExtension())
            .append("isUser", getIsUser())
            .append("isRecycle", getIsRecycle())
            .append("isDelete", getIsDelete())
            .append("macid", getMacid())
            .append("createTime", getCreateTime())
            .toString();
    }
}
