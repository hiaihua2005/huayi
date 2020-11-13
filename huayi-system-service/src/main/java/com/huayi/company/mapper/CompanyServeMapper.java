package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyServe;
import java.util.List;	

/**
 * 企业账号服务 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyServeMapper 
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
     * 删除企业账号服务
     * 
     * @param recordId 企业账号服务ID
     * @return 结果
     */
	public int deleteCompanyServeById(Integer recordId);
	
	/**
     * 批量删除企业账号服务
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyServeByIds(String[] recordIds);

    CompanyServe selectStandardServeByCompanyId(Integer companyId);

	CompanyServe selectStandardCompanyServe(Integer companyId);
}