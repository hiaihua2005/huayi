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
import com.huayi.company.domain.CompanyStaff;
import com.huayi.company.service.ICompanyStaffService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业与员工 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/staff")
public class CompanyStaffController extends BaseController
{
    private String prefix = "biz/company/staff";
	
	@Autowired
	private ICompanyStaffService companyStaffService;

	/**
	 * 查询企业与员工列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyStaff companyStaff)
	{
		startPage();
        List<CompanyStaff> list = companyStaffService.selectCompanyStaffList(companyStaff);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业与员工列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyStaff companyStaff)
    {
    	List<CompanyStaff> list = companyStaffService.selectCompanyStaffList(companyStaff);
        ExcelUtil<CompanyStaff> util = new ExcelUtil<CompanyStaff>(CompanyStaff.class);
        return util.exportExcel(list, "companyStaff");
    }
	

	/**
	 * 新增保存企业与员工
	 */
	@Log(title = "企业与员工", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyStaff companyStaff)
	{		
		return toAjax(companyStaffService.insertCompanyStaff(companyStaff));
	}

	/**
	 * 获取企业与员工
	 */
	@PostMapping("/info/{staffId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("staffId") Integer staffId, ModelMap mmap)
	{
		CompanyStaff companyStaff = companyStaffService.selectCompanyStaffById(staffId);
		mmap.put("companyStaff", companyStaff);
	    return toAjax(true,companyStaff);
	}
	
	/**
	 * 修改保存企业与员工
	 */
	@Log(title = "企业与员工", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyStaff companyStaff)
	{		
		return toAjax(companyStaffService.updateCompanyStaff(companyStaff));
	}
	
	/**
	 * 删除企业与员工
	 */
	@Log(title = "企业与员工", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyStaffService.deleteCompanyStaffByIds(ids));
	}
	
}
