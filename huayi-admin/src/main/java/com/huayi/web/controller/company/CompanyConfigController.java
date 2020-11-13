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
import com.huayi.company.domain.CompanyConfig;
import com.huayi.company.service.ICompanyConfigService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企管后台配置 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/config")
public class CompanyConfigController extends BaseController
{
    private String prefix = "biz/company/config";
	
	@Autowired
	private ICompanyConfigService companyConfigService;

	/**
	 * 查询企管后台配置列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyConfig companyConfig)
	{
		startPage();
        List<CompanyConfig> list = companyConfigService.selectCompanyConfigList(companyConfig);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企管后台配置列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyConfig companyConfig)
    {
    	List<CompanyConfig> list = companyConfigService.selectCompanyConfigList(companyConfig);
        ExcelUtil<CompanyConfig> util = new ExcelUtil<CompanyConfig>(CompanyConfig.class);
        return util.exportExcel(list, "companyConfig");
    }
	

	/**
	 * 新增保存企管后台配置
	 */
	@Log(title = "企管后台配置", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyConfig companyConfig)
	{		
		return toAjax(companyConfigService.insertCompanyConfig(companyConfig));
	}

	/**
	 * 获取企管后台配置
	 */
	@PostMapping("/info/{id}")
	@ResponseBody
	public AjaxResult info(@PathVariable("id") Integer id, ModelMap mmap)
	{
		CompanyConfig companyConfig = companyConfigService.selectCompanyConfigById(id);
	    return toAjax(true,companyConfig);
	}
	
	/**
	 * 修改保存企管后台配置
	 */
	@Log(title = "企管后台配置", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyConfig companyConfig)
	{		
		return toAjax(companyConfigService.updateCompanyConfig(companyConfig));
	}
	
	/**
	 * 删除企管后台配置
	 */
	@Log(title = "企管后台配置", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyConfigService.deleteCompanyConfigByIds(ids));
	}
	
}
