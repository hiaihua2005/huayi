package com.huayi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.system.mapper.SysDeptMapper;
import com.huayi.system.domain.SysDept;
import com.huayi.system.service.ISysDeptService;
import com.huayi.common.support.Convert;

/**
 * 企业部门 服务层实现
 * 
 * @author huayi
 * @date 2020-08-12
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService 
{
	@Autowired
	private SysDeptMapper sysDeptMapper;

	/**
     * 查询企业部门信息
     * 
     * @param deptId 企业部门ID
     * @return 企业部门信息
     */
    @Override
	public SysDept selectSysDeptById(Integer deptId)
	{
	    return sysDeptMapper.selectSysDeptById(deptId);
	}
	
	/**
     * 查询企业部门列表
     * 
     * @param sysDept 企业部门信息
     * @return 企业部门集合
     */
	@Override
	public List<SysDept> selectSysDeptList(SysDept sysDept)
	{
	    return sysDeptMapper.selectSysDeptList(sysDept);
	}
	
    /**
     * 新增企业部门
     * 
     * @param sysDept 企业部门信息
     * @return 结果
     */
	@Override
	public int insertSysDept(SysDept sysDept)
	{
	    return sysDeptMapper.insertSysDept(sysDept);
	}
	
	/**
     * 修改企业部门
     * 
     * @param sysDept 企业部门信息
     * @return 结果
     */
	@Override
	public int updateSysDept(SysDept sysDept)
	{
	    return sysDeptMapper.updateSysDept(sysDept);
	}

	/**
     * 删除企业部门对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSysDeptByIds(String ids)
	{
		return sysDeptMapper.deleteSysDeptByIds(Convert.toStrArray(ids));
	}
	
}
