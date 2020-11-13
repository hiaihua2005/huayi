package com.huayi.company.service;

import com.huayi.company.domain.CompanyUploadGroup;
import java.util.List;

/**
 * 资源分组记录 服务层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface ICompanyUploadGroupService 
{
	/**
     * 查询资源分组记录信息
     * 
     * @param groupId 资源分组记录ID
     * @return 资源分组记录信息
     */
	public CompanyUploadGroup selectCompanyUploadGroupById(Integer groupId);
	
	/**
     * 查询资源分组记录列表
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 资源分组记录集合
     */
	public List<CompanyUploadGroup> selectCompanyUploadGroupList(CompanyUploadGroup companyUploadGroup);
	
	/**
     * 新增资源分组记录
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 结果
     */
	public int insertCompanyUploadGroup(CompanyUploadGroup companyUploadGroup);
	
	/**
     * 修改资源分组记录
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 结果
     */
	public int updateCompanyUploadGroup(CompanyUploadGroup companyUploadGroup);
		
	/**
     * 删除资源分组记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyUploadGroupByIds(String ids);
	
}
