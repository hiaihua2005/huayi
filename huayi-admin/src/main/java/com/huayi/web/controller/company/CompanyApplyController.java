package com.huayi.web.controller.company;

import java.util.List;

import com.huayi.company.domain.CompanyApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.company.service.ICompanyApplyService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业申请（公司对应） 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/mallApply")
public class CompanyApplyController extends BaseController
{
    private String prefix = "biz/company/mallApply";
	
	@Autowired
	private ICompanyApplyService companyMallApplyService;

	/**
	 * 查询企业商户商城申请（商城与公司对应）列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyApply companyApply)
	{
		startPage();
        List<CompanyApply> list = companyMallApplyService.selectCompanyMallApplyList(companyApply);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业商户商城申请（商城与公司对应）列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyApply companyApply)
    {
    	List<CompanyApply> list = companyMallApplyService.selectCompanyMallApplyList(companyApply);
        ExcelUtil<CompanyApply> util = new ExcelUtil<CompanyApply>(CompanyApply.class);
        return util.exportExcel(list, "companyApply");
    }
	

	/**
	 * 新增保存企业商户商城申请（商城与公司对应）
	 */
	@Log(title = "企业商户商城申请（商城与公司对应）", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyApply companyApply)
	{		
		return toAjax(companyMallApplyService.insertCompanyMallApply(companyApply));
	}

	/**
	 * 获取企业商户商城申请（商城与公司对应）
	 */
	@PostMapping("/info/{recordId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("recordId") Integer recordId, ModelMap mmap)
	{
		CompanyApply companyApply = companyMallApplyService.selectCompanyMallApplyById(recordId);
	    return toAjax(true, companyApply);
	}
	
	/**
	 * 修改保存企业商户商城申请（商城与公司对应）
	 */
	@Log(title = "企业商户商城申请（商城与公司对应）", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyApply companyApply)
	{		
		return toAjax(companyMallApplyService.updateCompanyMallApply(companyApply));
	}
	
	/**
	 * 删除企业商户商城申请（商城与公司对应）
	 */
	@Log(title = "企业商户商城申请（商城与公司对应）", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyMallApplyService.deleteCompanyMallApplyByIds(ids));
	}
	
}
