package com.huayi.company.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyStaffMapper;
import com.huayi.company.domain.CompanyStaff;
import com.huayi.company.service.ICompanyStaffService;
import com.huayi.common.support.Convert;

/**
 * 企业与员工 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyStaffServiceImpl implements ICompanyStaffService 
{
	@Autowired
	private CompanyStaffMapper companyStaffMapper;

	/**
     * 查询企业与员工信息
     * 
     * @param staffId 企业与员工ID
     * @return 企业与员工信息
     */
    @Override
	public CompanyStaff selectCompanyStaffById(Integer staffId)
	{
	    return companyStaffMapper.selectCompanyStaffById(staffId);
	}
	
	/**
     * 查询企业与员工列表
     * 
     * @param companyStaff 企业与员工信息
     * @return 企业与员工集合
     */
	@Override
	public List<CompanyStaff> selectCompanyStaffList(CompanyStaff companyStaff)
	{
	    return companyStaffMapper.selectCompanyStaffList(companyStaff);
	}
	
    /**
     * 新增企业与员工
     * 
     * @param companyStaff 企业与员工信息
     * @return 结果
     */
	@Override
	public int insertCompanyStaff(CompanyStaff companyStaff)
	{
	    return companyStaffMapper.insertCompanyStaff(companyStaff);
	}
	
	/**
     * 修改企业与员工
     * 
     * @param companyStaff 企业与员工信息
     * @return 结果
     */
	@Override
	public int updateCompanyStaff(CompanyStaff companyStaff)
	{
	    return companyStaffMapper.updateCompanyStaff(companyStaff);
	}

	/**
     * 删除企业与员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCompanyStaffByIds(String ids)
	{
		return companyStaffMapper.deleteCompanyStaffByIds(Convert.toStrArray(ids));
	}
	
}
