package com.huayi.company.mapper;

import com.huayi.company.domain.CompanyVersion;
import java.util.List;	

/**
 * 小程序套餐 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface MpVersionMapper 
{
	/**
     * 查询小程序套餐信息
     * 
     * @param recordId 小程序套餐ID
     * @return 小程序套餐信息
     */
	public CompanyVersion selectMpVersionById(Integer recordId);
	
	/**
     * 查询小程序套餐列表
     * 
     * @param companyVersion 小程序套餐信息
     * @return 小程序套餐集合
     */
	public List<CompanyVersion> selectMpVersionList(CompanyVersion companyVersion);
	
	/**
     * 新增小程序套餐
     * 
     * @param companyVersion 小程序套餐信息
     * @return 结果
     */
	public int insertMpVersion(CompanyVersion companyVersion);
	
	/**
     * 修改小程序套餐
     * 
     * @param companyVersion 小程序套餐信息
     * @return 结果
     */
	public int updateMpVersion(CompanyVersion companyVersion);
	
	/**
     * 删除小程序套餐
     * 
     * @param recordId 小程序套餐ID
     * @return 结果
     */
	public int deleteMpVersionById(Integer recordId);
	
	/**
     * 批量删除小程序套餐
     * 
     * @param recordIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteMpVersionByIds(String[] recordIds);
	
}