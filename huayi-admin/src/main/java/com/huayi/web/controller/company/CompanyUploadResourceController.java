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
import com.huayi.company.domain.CompanyUploadResource;
import com.huayi.company.service.ICompanyUploadResourceService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 资源记录 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/company/uploadResource")
public class CompanyUploadResourceController extends BaseController
{
    private String prefix = "biz/company/uploadResource";
	
	@Autowired
	private ICompanyUploadResourceService companyUploadResourceService;

	/**
	 * 查询资源记录列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CompanyUploadResource companyUploadResource)
	{
		startPage();
        List<CompanyUploadResource> list = companyUploadResourceService.selectCompanyUploadResourceList(companyUploadResource);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出资源记录列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CompanyUploadResource companyUploadResource)
    {
    	List<CompanyUploadResource> list = companyUploadResourceService.selectCompanyUploadResourceList(companyUploadResource);
        ExcelUtil<CompanyUploadResource> util = new ExcelUtil<CompanyUploadResource>(CompanyUploadResource.class);
        return util.exportExcel(list, "companyUploadResource");
    }
	

	/**
	 * 新增保存资源记录
	 */
	@Log(title = "资源记录", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(CompanyUploadResource companyUploadResource)
	{		
		return toAjax(companyUploadResourceService.insertCompanyUploadResource(companyUploadResource));
	}

	/**
	 * 获取资源记录
	 */
	@PostMapping("/info/{resourceId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("resourceId") String resourceId, ModelMap mmap)
	{
		CompanyUploadResource companyUploadResource = companyUploadResourceService.selectCompanyUploadResourceById(resourceId);
	    return toAjax(true,companyUploadResource);
	}
	
	/**
	 * 修改保存资源记录
	 */
	@Log(title = "资源记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(CompanyUploadResource companyUploadResource)
	{		
		return toAjax(companyUploadResourceService.updateCompanyUploadResource(companyUploadResource));
	}
	
	/**
	 * 删除资源记录
	 */
	@Log(title = "资源记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(companyUploadResourceService.deleteCompanyUploadResourceByIds(ids));
	}
	
}
