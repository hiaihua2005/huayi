package com.huayi.company.service.impl;

import java.util.List;

import com.huayi.company.domain.CompanyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.company.mapper.CompanyOrderMapper;
import com.huayi.company.service.IMpOrderService;
import com.huayi.common.support.Convert;

/**
 * 套餐订购记录 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CompanyOrderServiceImpl implements IMpOrderService
{
	@Autowired
	private CompanyOrderMapper companyOrderMapper;

	/**
     * 查询套餐订购记录信息
     * 
     * @param orderId 套餐订购记录ID
     * @return 套餐订购记录信息
     */
    @Override
	public CompanyOrder selectMpOrderById(Integer orderId)
	{
	    return companyOrderMapper.selectMpOrderById(orderId);
	}
	
	/**
     * 查询套餐订购记录列表
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 套餐订购记录集合
     */
	@Override
	public List<CompanyOrder> selectMpOrderList(CompanyOrder companyOrder)
	{
	    return companyOrderMapper.selectMpOrderList(companyOrder);
	}
	
    /**
     * 新增套餐订购记录
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 结果
     */
	@Override
	public int insertMpOrder(CompanyOrder companyOrder)
	{
	    return companyOrderMapper.insertMpOrder(companyOrder);
	}
	
	/**
     * 修改套餐订购记录
     * 
     * @param companyOrder 套餐订购记录信息
     * @return 结果
     */
	@Override
	public int updateMpOrder(CompanyOrder companyOrder)
	{
	    return companyOrderMapper.updateMpOrder(companyOrder);
	}

	/**
     * 删除套餐订购记录对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMpOrderByIds(String ids)
	{
		return companyOrderMapper.deleteMpOrderByIds(Convert.toStrArray(ids));
	}
	
}
