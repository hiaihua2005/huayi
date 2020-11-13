package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyVerifyMapper;
import com.huayi.company.domain.CompanyVerify;
import com.huayi.company.service.ICompanyVerifyService;
import com.huayi.common.support.Convert;

/**
 * 企业认证 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyVerifyServiceImpl implements ICompanyVerifyService 
{
	@Autowired
	private CompanyVerifyMapper companyVerifyMapper;

	/**
     * 查询企业认证信息
     * 
     * @param verifyId 企业认证ID
     * @return 企业认证信息
     */
    @Override
	public CompanyVerify selectCompanyVerifyById(Integer verifyId)
	{
	    return companyVerifyMapper.selectCompanyVerifyById(verifyId);
	}
	
	/**
     * 查询企业认证列表
     * 
     * @param companyVerify 企业认证信息
     * @return 企业认证集合
     */
	@Override
	public List<CompanyVerify> selectCompanyVerifyList(CompanyVerify companyVerify)
	{
	    return companyVerifyMapper.selectCompanyVerifyList(companyVerify);
	}
	
    /**
     * 新增企业认证
     * 
     * @param companyVerify 企业认证信息
     * @return 结果
     */
	@Override
	public int insertCompanyVerify(CompanyVerify companyVerify)
	{
	    return companyVerifyMapper.insertCompanyVerify(companyVerify);
	}
	
	/**
     * 修改企业认证
     * 
     * @param companyVerify 企业认证信息
     * @return 结果
     */
	@Override
	public int updateCompanyVerify(CompanyVerify companyVerify)
	{
	    return companyVerifyMapper.updateCompanyVerify(companyVerify);
	}

	/**
     * 删除企业认证对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyVerifyByIds(String ids)
	{
		return companyVerifyMapper.deleteCompanyVerifyByIds(Convert.toStrArray(ids));
	}
	
}
