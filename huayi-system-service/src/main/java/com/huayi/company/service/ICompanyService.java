package com.huayi.company.service;

import com.huayi.company.domain.Company;

import java.util.List;

/**
 * 企业 服务层
 * 
 * @author huayi
 * @date 2020-08-15
 */
public interface ICompanyService
{
	/**
     * 查询企业信息
     * 
     * @param recordId 企业ID
     * @return 企业信息
     */
	public Company selectCompanyInfoById(Integer recordId);
	
	/**
     * 查询企业列表
     * 
     * @param company 企业信息
     * @return 企业集合
     */
	public List<Company> selectCompanyInfoList(Company company);
	
	/**
     * 新增企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	public int insertCompanyInfo(Company company);
	
	/**
     * 修改企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	public int updateCompanyInfo(Company company);
		
	/**
     * 删除企业信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyInfoByIds(String ids);
	
}
