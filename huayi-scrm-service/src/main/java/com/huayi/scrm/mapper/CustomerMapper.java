package com.huayi.scrm.mapper;

import com.huayi.scrm.domain.Customer;
import java.util.List;	

/**
 * 客户 数据层
 * 
 * @author huayi
 * @date 2020-08-16
 */
public interface CustomerMapper 
{
	/**
     * 查询客户信息
     * 
     * @param customerId 客户ID
     * @return 客户信息
     */
	public Customer selectCustomerById(Integer customerId);
	
	/**
     * 查询客户列表
     * 
     * @param customer 客户信息
     * @return 客户集合
     */
	public List<Customer> selectCustomerList(Customer customer);
	
	/**
     * 新增客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int insertCustomer(Customer customer);
	
	/**
     * 修改客户
     * 
     * @param customer 客户信息
     * @return 结果
     */
	public int updateCustomer(Customer customer);
	
	/**
     * 删除客户
     * 
     * @param customerId 客户ID
     * @return 结果
     */
	public int deleteCustomerById(Integer customerId);
	
	/**
     * 批量删除客户
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCustomerByIds(String[] customerIds);
	
}