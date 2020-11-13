package com.huayi.company.service;

import com.huayi.company.domain.CompanyOrder;

import java.util.List;

/**
 * 套餐订购记录 服务层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface IMpOrderService 
{
	/**
     * 查询套餐订购记录信息
     * 
     * @param orderId 套餐订购记录ID
     * @return 套餐订购记录信息
     */
	public CompanyOrder selectMpOrderById(Integer orderId);
	
	/**
     * 查询套餐订购记录列表
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 套餐订购记录集合
     */
	public List<CompanyOrder> selectMpOrderList(CompanyOrder companyOrder);
	
	/**
     * 新增套餐订购记录
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 结果
     */
	public int insertMpOrder(CompanyOrder companyOrder);
	
	/**
     * 修改套餐订购记录
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 结果
     */
	public int updateMpOrder(CompanyOrder companyOrder);
		
	/**
     * 删除套餐订购记录信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteMpOrderByIds(String ids);
	
}
