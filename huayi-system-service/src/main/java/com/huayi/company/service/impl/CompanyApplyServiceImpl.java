package com.huayi.company.service.impl;

import java.util.List;

import com.huayi.company.domain.CompanyApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyApplyMapper;
import com.huayi.company.service.ICompanyApplyService;
import com.huayi.common.support.Convert;

/**
 * 企业商户商城申请（商城与公司对应） 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyApplyServiceImpl implements ICompanyApplyService
{
	@Autowired
	private CompanyApplyMapper companyApplyMapper;

	/**
     * 查询企业商户商城申请（商城与公司对应）信息
     * 
     * @param recordId 企业商户商城申请（商城与公司对应）ID
     * @return 企业商户商城申请（商城与公司对应）信息
     */
    @Override
	public CompanyApply selectCompanyMallApplyById(Integer recordId)
	{
	    return companyApplyMapper.selectCompanyApplyById(recordId);
	}
	
	/**
     * 查询企业商户商城申请（商城与公司对应）列表
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 企业商户商城申请（商城与公司对应）集合
     */
	@Override
	public List<CompanyApply> selectCompanyMallApplyList(CompanyApply companyApply)
	{
	    return companyApplyMapper.selectCompanyApplyList(companyApply);
	}
	
    /**
     * 新增企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	@Override
	public int insertCompanyMallApply(CompanyApply companyApply)
	{
	    return companyApplyMapper.insertCompanyApply(companyApply);
	}
	
	/**
     * 修改企业商户商城申请（商城与公司对应）
     * 
     * @param companyApply 企业商户商城申请（商城与公司对应）信息
     * @return 结果
     */
	@Override
	public int updateCompanyMallApply(CompanyApply companyApply)
	{
	    return companyApplyMapper.updateCompanyApply(companyApply);
	}

	/**
     * 删除企业商户商城申请（商城与公司对应）对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyMallApplyByIds(String ids)
	{
		return companyApplyMapper.deleteCompanyApplyByIds(Convert.toStrArray(ids));
	}
	
}
