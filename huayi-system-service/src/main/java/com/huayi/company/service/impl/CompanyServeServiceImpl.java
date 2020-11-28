package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyServeMapper;
import com.huayi.company.domain.CompanyServe;
import com.huayi.company.service.ICompanyServeService;
import com.huayi.common.support.Convert;

/**
 * 企业账号服务 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyServeServiceImpl implements ICompanyServeService 
{
	@Autowired
	private CompanyServeMapper companyServeMapper;

	/**
     * 查询企业账号服务信息
     * 
     * @param companyId 企业账号服务ID
     * @return 企业账号服务信息
     */
    @Override
	public CompanyServe selectCompanyServeById(Long companyId)
	{
	    return companyServeMapper.selectCompanyServeById(companyId);
	}
	
	/**
     * 查询企业账号服务列表
     * 
     * @param companyServe 企业账号服务信息
     * @return 企业账号服务集合
     */
	@Override
	public List<CompanyServe> selectCompanyServeList(CompanyServe companyServe)
	{
	    return companyServeMapper.selectCompanyServeList(companyServe);
	}
	
    /**
     * 新增企业账号服务
     * 
     * @param companyServe 企业账号服务信息
     * @return 结果
     */
	@Override
	public int insertCompanyServe(CompanyServe companyServe)
	{
	    return companyServeMapper.insertCompanyServe(companyServe);
	}
	
	/**
     * 修改企业账号服务
     * 
     * @param companyServe 企业账号服务信息
     * @return 结果
     */
	@Override
	public int updateCompanyServe(CompanyServe companyServe)
	{
	    return companyServeMapper.updateCompanyServe(companyServe);
	}

	/**
     * 删除企业账号服务对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyServeByIds(String ids)
	{
		return companyServeMapper.deleteCompanyServeByIds(Convert.toStrArray(ids));
	}

	@Override
	public CompanyServe selectStandardCompanyServe(Long companyId) {
		return companyServeMapper.selectStandardCompanyServe(companyId);
	}

}
