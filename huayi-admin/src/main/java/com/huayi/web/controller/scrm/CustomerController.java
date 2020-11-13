package com.huayi.web.controller.scrm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.scrm.domain.Customer;
import com.huayi.scrm.service.ICustomerService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 客户 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/scrm/customer")
public class CustomerController extends BaseController
{
    private String prefix = "biz/scrm/customer";
	
	@Autowired
	private ICustomerService customerService;

	/**
	 * 查询客户列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Customer customer)
	{
		startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出客户列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
    	List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "customer");
    }
	

	/**
	 * 新增保存客户
	 */
	@Log(title = "客户", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(Customer customer)
	{		
		return toAjax(customerService.insertCustomer(customer));
	}

	/**
	 * 获取客户
	 */
	@PostMapping("/info/{customerId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("customerId") Integer customerId, ModelMap mmap)
	{
		Customer customer = customerService.selectCustomerById(customerId);
	    return toAjax(true,customer);
	}
	
	/**
	 * 修改保存客户
	 */
	@Log(title = "客户", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(Customer customer)
	{		
		return toAjax(customerService.updateCustomer(customer));
	}
	
	/**
	 * 删除客户
	 */
	@Log(title = "客户", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(customerService.deleteCustomerByIds(ids));
	}
	
}
