package com.huayi.company.service.impl;

import java.util.List;

import com.huayi.company.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyMapper;
import com.huayi.company.service.ICompanyService;
import com.huayi.common.support.Convert;

/**
 * 企业 服务层实现
 * 
 * @author huayi
 * @date 2020-08-15
 */
@Service
public class CompanyServiceImpl implements ICompanyService
{
	@Autowired
	private CompanyMapper companyMapper;

	/**
     * 查询企业信息
     * 
     * @param companyId 企业ID
     * @return 企业信息
     */
    @Override
	public Company selectCompanyInfoById(Long companyId)
	{
	    return companyMapper.selectCompanyInfoById(companyId);
	}
	
	/**
     * 查询企业列表
     * 
     * @param company 企业信息
     * @return 企业集合
     */
	@Override
	public List<Company> selectCompanyInfoList(Company company)
	{
	    return companyMapper.selectCompanyInfoList(company);
	}
	
    /**
     * 新增企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	@Override
	public int insertCompanyInfo(Company company)
	{
	    return companyMapper.insertCompanyInfo(company);
	}
	
	/**
     * 修改企业
     * 
     * @param company 企业信息
     * @return 结果
     */
	@Override
	public int updateCompanyInfo(Company company)
	{
	    return companyMapper.updateCompanyInfo(company);
	}

	/**
     * 删除企业对象
     *
     * @param id 需要删除的企业ID
     * @return 结果
     */
	@Override
	public int deleteCompanyInfoById(Long id)
	{
		return companyMapper.deleteCompanyInfoById(id);
	}
	
}
