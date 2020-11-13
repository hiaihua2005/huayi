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
import com.huayi.company.domain.CompanyUploadGroup;
import com.huayi.company.service.ICompanyUploadGroupService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 资源分组记录 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/uploadGroup")
public class CompanyUploadGroupController extends BaseController
{
    private String prefix = "biz/company/uploadGroup";
	
	@Autowired
	private ICompanyUploadGroupService companyUploadGroupService;

	/**
	 * 查询资源分组记录列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyUploadGroup companyUploadGroup)
	{
		startPage();
        List<CompanyUploadGroup> list = companyUploadGroupService.selectCompanyUploadGroupList(companyUploadGroup);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资源分组记录列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyUploadGroup companyUploadGroup)
    {
    	List<CompanyUploadGroup> list = companyUploadGroupService.selectCompanyUploadGroupList(companyUploadGroup);
        ExcelUtil<CompanyUploadGroup> util = new ExcelUtil<CompanyUploadGroup>(CompanyUploadGroup.class);
        return util.exportExcel(list, "companyUploadGroup");
    }
	

	/**
	 * 新增保存资源分组记录
	 */
	@Log(title = "资源分组记录", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyUploadGroup companyUploadGroup)
	{		
		return toAjax(companyUploadGroupService.insertCompanyUploadGroup(companyUploadGroup));
	}

	/**
	 * 获取资源分组记录
	 */
	@PostMapping("/info/{groupId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("groupId") Integer groupId, ModelMap mmap)
	{
		CompanyUploadGroup companyUploadGroup = companyUploadGroupService.selectCompanyUploadGroupById(groupId);
	    return toAjax(true,companyUploadGroup);
	}
	
	/**
	 * 修改保存资源分组记录
	 */
	@Log(title = "资源分组记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyUploadGroup companyUploadGroup)
	{		
		return toAjax(companyUploadGroupService.updateCompanyUploadGroup(companyUploadGroup));
	}
	
	/**
	 * 删除资源分组记录
	 */
	@Log(title = "资源分组记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyUploadGroupService.deleteCompanyUploadGroupByIds(ids));
	}
	
}
