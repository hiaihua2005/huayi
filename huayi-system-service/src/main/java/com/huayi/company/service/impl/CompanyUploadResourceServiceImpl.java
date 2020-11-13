package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyUploadResourceMapper;
import com.huayi.company.domain.CompanyUploadResource;
import com.huayi.company.service.ICompanyUploadResourceService;
import com.huayi.common.support.Convert;

/**
 * 资源记录 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyUploadResourceServiceImpl implements ICompanyUploadResourceService 
{
	@Autowired
	private CompanyUploadResourceMapper companyUploadResourceMapper;

	/**
     * 查询资源记录信息
     * 
     * @param resourceId 资源记录ID
     * @return 资源记录信息
     */
    @Override
	public CompanyUploadResource selectCompanyUploadResourceById(String resourceId)
	{
	    return companyUploadResourceMapper.selectCompanyUploadResourceById(resourceId);
	}
	
	/**
     * 查询资源记录列表
     * 
     * @param companyUploadResource 资源记录信息
     * @return 资源记录集合
     */
	@Override
	public List<CompanyUploadResource> selectCompanyUploadResourceList(CompanyUploadResource companyUploadResource)
	{
	    return companyUploadResourceMapper.selectCompanyUploadResourceList(companyUploadResource);
	}
	
    /**
     * 新增资源记录
     * 
     * @param companyUploadResource 资源记录信息
     * @return 结果
     */
	@Override
	public int insertCompanyUploadResource(CompanyUploadResource companyUploadResource)
	{
	    return companyUploadResourceMapper.insertCompanyUploadResource(companyUploadResource);
	}
	
	/**
     * 修改资源记录
     * 
     * @param companyUploadResource 资源记录信息
     * @return 结果
     */
	@Override
	public int updateCompanyUploadResource(CompanyUploadResource companyUploadResource)
	{
	    return companyUploadResourceMapper.updateCompanyUploadResource(companyUploadResource);
	}

	/**
     * 删除资源记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyUploadResourceByIds(String ids)
	{
		return companyUploadResourceMapper.deleteCompanyUploadResourceByIds(Convert.toStrArray(ids));
	}
	
}
