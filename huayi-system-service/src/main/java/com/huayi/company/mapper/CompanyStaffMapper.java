package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyStaff;
import java.util.List;	

/**
 * 企业与员工 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CompanyStaffMapper 
{
	/**
     * 查询企业与员工信息
     * 
     * @param staffId 企业与员工ID
     * @return 企业与员工信息
     */
	public CompanyStaff selectCompanyStaffById(Integer staffId);
	
	/**
     * 查询企业与员工列表
     * 
     * @param companyStaff 企业与员工信息
     * @return 企业与员工集合
     */
	public List<CompanyStaff> selectCompanyStaffList(CompanyStaff companyStaff);
	
	/**
     * 新增企业与员工
     * 
     * @param companyStaff 企业与员工信息
     * @return 结果
     */
	public int insertCompanyStaff(CompanyStaff companyStaff);
	
	/**
     * 修改企业与员工
     * 
     * @param companyStaff 企业与员工信息
     * @return 结果
     */
	public int updateCompanyStaff(CompanyStaff companyStaff);
	
	/**
     * 删除企业与员工
     * 
     * @param staffId 企业与员工ID
     * @return 结果
     */
	public int deleteCompanyStaffById(Integer staffId);
	
	/**
     * 批量删除企业与员工
     * 
     * @param staffIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCompanyStaffByIds(String[] staffIds);
	
}