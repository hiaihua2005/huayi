package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyConfig;
import java.util.List;	

/**
 * 企管后台配置 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyConfigMapper 
{
	/**
     * 查询企管后台配置信息
     * 
     * @param id 企管后台配置ID
     * @return 企管后台配置信息
     */
	public CompanyConfig selectCompanyConfigById(Integer id);
	
	/**
     * 查询企管后台配置列表
     * 
     * @param companyConfig 企管后台配置信息
     * @return 企管后台配置集合
     */
	public List<CompanyConfig> selectCompanyConfigList(CompanyConfig companyConfig);
	
	/**
     * 新增企管后台配置
     * 
     * @param companyConfig 企管后台配置信息
     * @return 结果
     */
	public int insertCompanyConfig(CompanyConfig companyConfig);
	
	/**
     * 修改企管后台配置
     * 
     * @param companyConfig 企管后台配置信息
     * @return 结果
     */
	public int updateCompanyConfig(CompanyConfig companyConfig);
	
	/**
     * 删除企管后台配置
     * 
     * @param id 企管后台配置ID
     * @return 结果
     */
	public int deleteCompanyConfigById(Integer id);
	
	/**
     * 批量删除企管后台配置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyConfigByIds(String[] ids);
	
}