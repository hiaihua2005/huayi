package com.huayi.company.service.impl;

import java.util.List;

import com.huayi.company.domain.CompanyVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.MpVersionMapper;
import com.huayi.company.service.ICompanyVersionService;
import com.huayi.common.support.Convert;

/**
 * 小程序套餐 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyVersionServiceImpl implements ICompanyVersionService
{
	@Autowired
	private MpVersionMapper mpVersionMapper;

	/**
     * 查询小程序套餐信息
     * 
     * @param recordId 小程序套餐ID
     * @return 小程序套餐信息
     */
    @Override
	public CompanyVersion selectMpVersionById(Integer recordId)
	{
	    return mpVersionMapper.selectMpVersionById(recordId);
	}
	
	/**
     * 查询小程序套餐列表
     * 
     * @param companyVersion 小程序套餐信息
     * @return 小程序套餐集合
     */
	@Override
	public List<CompanyVersion> selectMpVersionList(CompanyVersion companyVersion)
	{
	    return mpVersionMapper.selectMpVersionList(companyVersion);
	}
	
    /**
     * 新增小程序套餐
     * 
     * @param companyVersion 小程序套餐信息
     * @return 结果
     */
	@Override
	public int insertMpVersion(CompanyVersion companyVersion)
	{
	    return mpVersionMapper.insertMpVersion(companyVersion);
	}
	
	/**
     * 修改小程序套餐
     * 
     * @param companyVersion 小程序套餐信息
     * @return 结果
     */
	@Override
	public int updateMpVersion(CompanyVersion companyVersion)
	{
	    return mpVersionMapper.updateMpVersion(companyVersion);
	}

	/**
     * 删除小程序套餐对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMpVersionByIds(String ids)
	{
		return mpVersionMapper.deleteMpVersionByIds(Convert.toStrArray(ids));
	}
	
}
