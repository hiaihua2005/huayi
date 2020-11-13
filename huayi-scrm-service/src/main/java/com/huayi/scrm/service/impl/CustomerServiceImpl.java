package com.huayi.scrm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.huayi.scrm.mapper.CustomerMapper;
import com.huayi.scrm.domain.Customer;
import com.huayi.scrm.service.ICustomerService;
import com.huayi.common.support.Convert;

/**
 * 客户 服务层实现
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
	@Autowired
	private CustomerMapper customerMapper;

	/**
     * 查询客户信息
     * 
     * @param customerId 客户ID
     * @return 客户信息
     */
    @Override
	public Customer selectCustomerById(Integer customerId)
	{
	    return customerMapper.selectCustomerById(customerId);
	}
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	@Override
	public List<Customer> selectCustomerList(Customer customer)
	{
	    return customerMapper.selectCustomerList(customer);
	}
	
    /**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int insertCustomer(Customer customer)
	{
	    return customerMapper.insertCustomer(customer);
	}
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	@Override
	public int updateCustomer(Customer customer)
	{
	    return customerMapper.updateCustomer(customer);
	}

	/**
     * 删除客户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCustomerByIds(String ids)
	{
		return customerMapper.deleteCustomerByIds(Convert.toStrArray(ids));
	}
	
}
