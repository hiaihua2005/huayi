package com.huayi.company.service;

import com.huayi.company.domain.CompanyApply;

import java.util.List;

/**
 * 企业商户商城申请（商城与公司对应） 服务层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface ICompanyApplyService
{
	/**
     * 查询企业商户商城申请（商城与公司对应）信息
     * 
     * @param recordId 企业商户商城申请（商城与公司对应）ID
     * @return 企业商户商城申请（商城与公司对应）信息
     */
	public CompanyApply selectCompanyMallApplyById(Integer recordId);
	
	/**
     * 查询企业商户商城申请（商城与公司对应）列表
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 企业商户商城申请（商城与公司对应）集合
     */
	public List<CompanyApply> selectCompanyMallApplyList(CompanyApply companyApply);
	
	/**
     * 新增企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	public int insertCompanyMallApply(CompanyApply companyApply);
	
	/**
     * 修改企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	public int updateCompanyMallApply(CompanyApply companyApply);
		
	/**
     * 删除企业商户商城申请（商城与公司对应）信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyMallApplyByIds(String ids);
	
}
