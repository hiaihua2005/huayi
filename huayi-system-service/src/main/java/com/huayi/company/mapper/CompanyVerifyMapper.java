package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyVerify;
import java.util.List;	

/**
 * 企业认证 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyVerifyMapper 
{
	/**
     * 查询企业认证信息
     * 
     * @param verifyId 企业认证ID
     * @return 企业认证信息
     */
	public CompanyVerify selectCompanyVerifyById(Integer verifyId);
	
	/**
     * 查询企业认证列表
     * 
     * @param companyVerify 企业认证信息
     * @return 企业认证集合
     */
	public List<CompanyVerify> selectCompanyVerifyList(CompanyVerify companyVerify);
	
	/**
     * 新增企业认证
     * 
     * @param companyVerify 企业认证信息
     * @return 结果
     */
	public int insertCompanyVerify(CompanyVerify companyVerify);
	
	/**
     * 修改企业认证
     * 
     * @param companyVerify 企业认证信息
     * @return 结果
     */
	public int updateCompanyVerify(CompanyVerify companyVerify);
	
	/**
     * 删除企业认证
     * 
     * @param verifyId 企业认证ID
     * @return 结果
     */
	public int deleteCompanyVerifyById(Integer verifyId);
	
	/**
     * 批量删除企业认证
     * 
     * @param verifyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyVerifyByIds(String[] verifyIds);
	
}