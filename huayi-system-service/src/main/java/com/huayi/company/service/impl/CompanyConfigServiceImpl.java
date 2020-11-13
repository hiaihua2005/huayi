package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyConfigMapper;
import com.huayi.company.domain.CompanyConfig;
import com.huayi.company.service.ICompanyConfigService;
import com.huayi.common.support.Convert;

/**
 * 企管后台配置 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyConfigServiceImpl implements ICompanyConfigService 
{
	@Autowired
	private CompanyConfigMapper companyConfigMapper;

	/**
     * 查询企管后台配置信息
     * 
     * @param id 企管后台配置ID
     * @return 企管后台配置信息
     */
    @Override
	public CompanyConfig selectCompanyConfigById(Integer id)
	{
	    return companyConfigMapper.selectCompanyConfigById(id);
	}
	
	/**
     * 查询企管后台配置列表
     * 
     * @param companyConfig 企管后台配置信息
     * @return 企管后台配置集合
     */
	@Override
	public List<CompanyConfig> selectCompanyConfigList(CompanyConfig companyConfig)
	{
	    return companyConfigMapper.selectCompanyConfigList(companyConfig);
	}
	
    /**
     * 新增企管后台配置
     * 
     * @param companyConfig 企管后台配置信息
     * @return 结果
     */
	@Override
	public int insertCompanyConfig(CompanyConfig companyConfig)
	{
	    return companyConfigMapper.insertCompanyConfig(companyConfig);
	}
	
	/**
     * 修改企管后台配置
     * 
     * @param companyConfig 企管后台配置信息
     * @return 结果
     */
	@Override
	public int updateCompanyConfig(CompanyConfig companyConfig)
	{
	    return companyConfigMapper.updateCompanyConfig(companyConfig);
	}

	/**
     * 删除企管后台配置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyConfigByIds(String ids)
	{
		return companyConfigMapper.deleteCompanyConfigByIds(Convert.toStrArray(ids));
	}
	
}
