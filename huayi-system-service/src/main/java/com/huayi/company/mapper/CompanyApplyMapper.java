package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyApply;

import java.util.List;	

/**
 * 企业商户商城申请（商城与公司对应） 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyApplyMapper 
{
	/**
     * 查询企业商户商城申请（商城与公司对应）信息
     * 
     * @param recordId 企业商户商城申请（商城与公司对应）ID
     * @return 企业商户商城申请（商城与公司对应）信息
     */
	public CompanyApply selectCompanyApplyById(Integer recordId);
	
	/**
     * 查询企业商户商城申请（商城与公司对应）列表
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 企业商户商城申请（商城与公司对应）集合
     */
	public List<CompanyApply> selectCompanyApplyList(CompanyApply companyApply);
	
	/**
     * 新增企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	public int insertCompanyApply(CompanyApply companyApply);
	
	/**
     * 修改企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	public int updateCompanyApply(CompanyApply companyApply);
	
	/**
     * 删除企业商户商城申请（商城与公司对应）
     * 
     * @param recordId 企业商户商城申请（商城与公司对应）ID
     * @return 结果
     */
	public int deleteCompanyApplyById(Integer recordId);
	
	/**
     * 批量删除企业商户商城申请（商城与公司对应）
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyApplyByIds(String[] recordIds);
	
}