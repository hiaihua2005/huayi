package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyUploadResource;
import java.util.List;	

/**
 * 资源记录 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyUploadResourceMapper 
{
	/**
     * 查询资源记录信息
     * 
     * @param resourceId 资源记录ID
     * @return 资源记录信息
     */
	public CompanyUploadResource selectCompanyUploadResourceById(String resourceId);
	
	/**
     * 查询资源记录列表
     * 
     * @param companyUploadResource 资源记录信息
     * @return 资源记录集合
     */
	public List<CompanyUploadResource> selectCompanyUploadResourceList(CompanyUploadResource companyUploadResource);
	
	/**
     * 新增资源记录
     * 
     * @param companyUploadResource 资源记录信息
     * @return 结果
     */
	public int insertCompanyUploadResource(CompanyUploadResource companyUploadResource);
	
	/**
     * 修改资源记录
     * 
     * @param companyUploadResource 资源记录信息
     * @return 结果
     */
	public int updateCompanyUploadResource(CompanyUploadResource companyUploadResource);
	
	/**
     * 删除资源记录
     * 
     * @param resourceId 资源记录ID
     * @return 结果
     */
	public int deleteCompanyUploadResourceById(String resourceId);
	
	/**
     * 批量删除资源记录
     * 
     * @param resourceIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyUploadResourceByIds(String[] resourceIds);
	
}