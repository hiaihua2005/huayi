package com.huayi.web.controller.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.huayi.company.domain.Company;
import com.huayi.company.domain.CompanyServe;
import com.huayi.company.service.ICompanyServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.company.service.ICompanyService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-15
 */
@Controller
@RequestMapping("/biz/company")
public class CompanyController extends BaseController
{
    private String prefix = "biz/company";
	
	@Autowired
	private ICompanyService companyInfoService;

	@Autowired
	private ICompanyServeService companyServeService;

	/**
	 * 查询企业列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Company company)
	{
		startPage();
        List<Company> list = companyInfoService.selectCompanyInfoList(company);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
    	List<Company> list = companyInfoService.selectCompanyInfoList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "company");
    }

	/**
	 * 新增保存企业
	 */
	@Log(title = "企业", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(Company company)
	{		
		return toAjax(companyInfoService.insertCompanyInfo(company));
	}

	/**
	 * 企业信息
	 */
	@PostMapping("/info/{recordId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("companyId") Integer companyId, ModelMap mmap)
	{
		if(companyId ==null || companyId.intValue()==0) {
			return error(500,"新零售门户编号为空",null);
		}
		Company company = companyInfoService.selectCompanyInfoById(companyId);
		CompanyServe companyServe = companyServeService.selectStandardCompanyServe(companyId);
	    Map<String,Object> dataMap = new HashMap();

		return toAjax(true, company);
	}
	
	/**
	 * 修改保存企业
	 */
	@Log(title = "企业", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(Company company)
	{		
		return toAjax(companyInfoService.updateCompanyInfo(company));
	}
	
	/**
	 * 删除企业
	 */
	@Log(title = "企业", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyInfoService.deleteCompanyInfoByIds(ids));
	}
	
}
