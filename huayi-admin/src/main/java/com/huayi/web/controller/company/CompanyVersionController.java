package com.huayi.web.controller.company;

import java.util.List;

import com.huayi.company.domain.CompanyVersion;
import com.huayi.company.service.ICompanyVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业版本 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/version")
public class CompanyVersionController extends BaseController
{
    private String prefix = "biz/company/version";
	
	@Autowired
	private ICompanyVersionService companyVersionService;

	/**
	 * 查询企业版本列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyVersion companyVersion)
	{
		startPage();
        List<CompanyVersion> list = companyVersionService.selectMpVersionList(companyVersion);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业版本列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyVersion companyVersion)
    {
    	List<CompanyVersion> list = companyVersionService.selectMpVersionList(companyVersion);
        ExcelUtil<CompanyVersion> util = new ExcelUtil<CompanyVersion>(CompanyVersion.class);
        return util.exportExcel(list, "companyVersion");
    }
	

	/**
	 * 新增保存企业版本
	 */
	@Log(title = "企业版本", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyVersion companyVersion)
	{		
		return toAjax(companyVersionService.insertMpVersion(companyVersion));
	}

	/**
	 * 获取企业版本
	 */
	@PostMapping("/info/{recordId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("recordId") Integer recordId, ModelMap mmap)
	{
		CompanyVersion companyVersion = companyVersionService.selectMpVersionById(recordId);
	    return toAjax(true, companyVersion);
	}
	
	/**
	 * 修改保存企业版本
	 */
	@Log(title = "企业版本", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyVersion companyVersion)
	{		
		return toAjax(companyVersionService.updateMpVersion(companyVersion));
	}
	
	/**
	 * 删除企业版本
	 */
	@Log(title = "企业版本", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyVersionService.deleteMpVersionByIds(ids));
	}
	
}
