package com.huayi.web.controller.company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.company.domain.CompanyServe;
import com.huayi.company.service.ICompanyServeService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业账号服务 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/serve")
public class CompanyServeController extends BaseController
{
    private String prefix = "biz/company/serve";
	
	@Autowired
	private ICompanyServeService companyServeService;

	/**
	 * 查询企业账号服务列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyServe companyServe)
	{
		startPage();
        List<CompanyServe> list = companyServeService.selectCompanyServeList(companyServe);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业账号服务列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyServe companyServe)
    {
    	List<CompanyServe> list = companyServeService.selectCompanyServeList(companyServe);
        ExcelUtil<CompanyServe> util = new ExcelUtil<CompanyServe>(CompanyServe.class);
        return util.exportExcel(list, "companyServe");
    }
	

	
	/**
	 * 新增保存企业账号服务
	 */
	@Log(title = "企业账号服务", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyServe companyServe)
	{		
		return toAjax(companyServeService.insertCompanyServe(companyServe));
	}

	/**
	 * 修改企业账号服务
	 */
	@PostMapping("/info/{recordId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("recordId") Integer recordId, ModelMap mmap)
	{
		CompanyServe companyServe = companyServeService.selectCompanyServeById(recordId);
		return toAjax(true,companyServe);
	}
	
	/**
	 * 修改保存企业账号服务
	 */
	@Log(title = "企业账号服务", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CompanyServe companyServe)
	{		
		return toAjax(companyServeService.updateCompanyServe(companyServe));
	}
	
	/**
	 * 删除企业账号服务
	 */
	@Log(title = "企业账号服务", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyServeService.deleteCompanyServeByIds(ids));
	}
	
}
