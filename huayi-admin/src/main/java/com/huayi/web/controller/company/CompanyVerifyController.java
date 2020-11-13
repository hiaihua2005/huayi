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
import com.huayi.company.domain.CompanyVerify;
import com.huayi.company.service.ICompanyVerifyService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业认证 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/verify")
public class CompanyVerifyController extends BaseController
{
    private String prefix = "biz/company/verify";
	
	@Autowired
	private ICompanyVerifyService companyVerifyService;

	/**
	 * 查询企业认证列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyVerify companyVerify)
	{
		startPage();
        List<CompanyVerify> list = companyVerifyService.selectCompanyVerifyList(companyVerify);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业认证列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyVerify companyVerify)
    {
    	List<CompanyVerify> list = companyVerifyService.selectCompanyVerifyList(companyVerify);
        ExcelUtil<CompanyVerify> util = new ExcelUtil<CompanyVerify>(CompanyVerify.class);
        return util.exportExcel(list, "companyVerify");
    }
	

	/**
	 * 新增保存企业认证
	 */
	@Log(title = "企业认证", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyVerify companyVerify)
	{		
		return toAjax(companyVerifyService.insertCompanyVerify(companyVerify));
	}

	/**
	 * 获取企业认证
	 */
	@PostMapping("/info/{verifyId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("verifyId") Integer verifyId, ModelMap mmap)
	{
		CompanyVerify companyVerify = companyVerifyService.selectCompanyVerifyById(verifyId);
	    return toAjax(true,companyVerify);
	}
	
	/**
	 * 修改保存企业认证
	 */
	@Log(title = "企业认证", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyVerify companyVerify)
	{		
		return toAjax(companyVerifyService.updateCompanyVerify(companyVerify));
	}
	
	/**
	 * 删除企业认证
	 */
	@Log(title = "企业认证", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyVerifyService.deleteCompanyVerifyByIds(ids));
	}
	
}
