package com.huayi.company.service;

import com.huayi.company.domain.CompanyServe;
import java.util.List;

/**
 * 企业账号服务 服务层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface ICompanyServeService 
{
	/**
     * 查询企业账号服务信息
     * 
     * @param recordId 企业账号服务ID
     * @return 企业账号服务信息
     */
	public CompanyServe selectCompanyServeById(Integer recordId);
	
	/**
     * 查询企业账号服务列表
     * 
     * @param companyServe 企业账号服务信息
     * @return 企业账号服务集合
     */
	public List<CompanyServe> selectCompanyServeList(CompanyServe companyServe);
	
	/**
     * 新增企业账号服务
     * 
     * @param companyServe 企业账号服务信息
     * @return 结果
     */
	public int insertCompanyServe(CompanyServe companyServe);
	
	/**
     * 修改企业账号服务
     * 
     * @param companyServe 企业账号服务信息
     * @return 结果
     */
	public int updateCompanyServe(CompanyServe companyServe);
		
	/**
     * 删除企业账号服务信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyServeByIds(String ids);

    CompanyServe selectStandardCompanyServe(Integer companyId);
}
