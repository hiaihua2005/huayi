package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyUploadGroupMapper;
import com.huayi.company.domain.CompanyUploadGroup;
import com.huayi.company.service.ICompanyUploadGroupService;
import com.huayi.common.support.Convert;

/**
 * 资源分组记录 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyUploadGroupServiceImpl implements ICompanyUploadGroupService 
{
	@Autowired
	private CompanyUploadGroupMapper companyUploadGroupMapper;

	/**
     * 查询资源分组记录信息
     * 
     * @param groupId 资源分组记录ID
     * @return 资源分组记录信息
     */
    @Override
	public CompanyUploadGroup selectCompanyUploadGroupById(Integer groupId)
	{
	    return companyUploadGroupMapper.selectCompanyUploadGroupById(groupId);
	}
	
	/**
     * 查询资源分组记录列表
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 资源分组记录集合
     */
	@Override
	public List<CompanyUploadGroup> selectCompanyUploadGroupList(CompanyUploadGroup companyUploadGroup)
	{
	    return companyUploadGroupMapper.selectCompanyUploadGroupList(companyUploadGroup);
	}
	
    /**
     * 新增资源分组记录
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 结果
     */
	@Override
	public int insertCompanyUploadGroup(CompanyUploadGroup companyUploadGroup)
	{
	    return companyUploadGroupMapper.insertCompanyUploadGroup(companyUploadGroup);
	}
	
	/**
     * 修改资源分组记录
     * 
     * @param companyUploadGroup 资源分组记录信息
     * @return 结果
     */
	@Override
	public int updateCompanyUploadGroup(CompanyUploadGroup companyUploadGroup)
	{
	    return companyUploadGroupMapper.updateCompanyUploadGroup(companyUploadGroup);
	}

	/**
     * 删除资源分组记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyUploadGroupByIds(String ids)
	{
		return companyUploadGroupMapper.deleteCompanyUploadGroupByIds(Convert.toStrArray(ids));
	}
	
}
