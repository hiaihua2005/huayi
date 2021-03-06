package com.huayi.system.service;

import com.huayi.system.domain.SysDept;
import java.util.List;

/**
 * 企业部门 服务层
 * 
 * @author huayi
 * @date 2020-08-12
 */
public interface ISysDeptService 
{
	/**
     * 查询企业部门信息
     * 
     * @param deptId 企业部门ID
     * @return 企业部门信息
     */
	public SysDept selectSysDeptById(Integer deptId);
	
	/**
     * 查询企业部门列表
     * 
     * @param sysDept 企业部门信息
     * @return 企业部门集合
     */
	public List<SysDept> selectSysDeptList(SysDept sysDept);
	
	/**
     * 新增企业部门
     * 
     * @param sysDept 企业部门信息
     * @return 结果
     */
	public int insertSysDept(SysDept sysDept);
	
	/**
     * 修改企业部门
     * 
     * @param sysDept 企业部门信息
     * @return 结果
     */
	public int updateSysDept(SysDept sysDept);
		
	/**
     * 删除企业部门信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSysDeptByIds(String ids);
	
}
