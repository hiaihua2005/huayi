package com.huayi.web.controller.company;

import java.util.List;

import com.huayi.company.domain.CompanyOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.company.service.IMpOrderService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 套餐订购记录 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/order")
public class CompanyOrderController extends BaseController
{
    private String prefix = "biz/company/order";
	
	@Autowired
	private IMpOrderService mpOrderService;

	/**
	 * 查询套餐订购记录列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyOrder companyOrder)
	{
		startPage();
        List<CompanyOrder> list = mpOrderService.selectMpOrderList(companyOrder);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出套餐订购记录列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyOrder companyOrder)
    {
    	List<CompanyOrder> list = mpOrderService.selectMpOrderList(companyOrder);
        ExcelUtil<CompanyOrder> util = new ExcelUtil<CompanyOrder>(CompanyOrder.class);
        return util.exportExcel(list, "companyOrder");
    }
	

	/**
	 * 新增保存套餐订购记录
	 */
	@Log(title = "套餐订购记录", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyOrder companyOrder)
	{		
		return toAjax(mpOrderService.insertMpOrder(companyOrder));
	}

	/**
	 * 获取套餐订购记录
	 */
	@PostMapping("/info/{orderId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("orderId") Integer orderId, ModelMap mmap)
	{
		CompanyOrder companyOrder = mpOrderService.selectMpOrderById(orderId);
	    return toAjax(true, companyOrder);
	}
	
	/**
	 * 修改保存套餐订购记录
	 */
	@Log(title = "套餐订购记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyOrder companyOrder)
	{		
		return toAjax(mpOrderService.updateMpOrder(companyOrder));
	}
	
	/**
	 * 删除套餐订购记录
	 */
	@Log(title = "套餐订购记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(mpOrderService.deleteMpOrderByIds(ids));
	}
	
}
