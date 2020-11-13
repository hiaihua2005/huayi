package com.huayi.web.controller.system;

import java.util.List;

import com.huayi.framework.web.base.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.system.domain.SysDept;
import com.huayi.system.service.ISysDeptService;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 企业部门 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-12
 */
@Controller
@RequestMapping("/biz/dept")
public class SysDeptController extends BaseController
{
    private String prefix = "biz/dept";
	
	@Autowired
	private ISysDeptService sysDeptService;
	
	@RequiresPermissions("system:sysDept:view")
	@GetMapping()
	public String sysDept()
	{
	    return prefix + "/sysDept";
	}
	
	/**
	 * 查询企业部门列表
	 */
	@RequiresPermissions("system:sysDept:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(SysDept sysDept)
	{
		startPage();
        List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业部门列表
	 */
	@RequiresPermissions("system:sysDept:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysDept sysDept)
    {
    	List<SysDept> list = sysDeptService.selectSysDeptList(sysDept);
        ExcelUtil<SysDept> util = new ExcelUtil<SysDept>(SysDept.class);
        return util.exportExcel(list, "sysDept");
    }
	
	/**
	 * 新增企业部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业部门
	 */
	@RequiresPermissions("system:sysDept:add")
	@Log(title = "企业部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(SysDept sysDept)
	{		
		return toAjax(sysDeptService.insertSysDept(sysDept));
	}

	/**
	 * 修改企业部门
	 */
	@GetMapping("/edit/{deptId}")
	public String edit(@PathVariable("deptId") Integer deptId, ModelMap mmap)
	{
		SysDept sysDept = sysDeptService.selectSysDeptById(deptId);
		mmap.put("sysDept", sysDept);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业部门
	 */
	@RequiresPermissions("system:sysDept:edit")
	@Log(title = "企业部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(SysDept sysDept)
	{		
		return toAjax(sysDeptService.updateSysDept(sysDept));
	}
	
	/**
	 * 删除企业部门
	 */
	@RequiresPermissions("system:sysDept:remove")
	@Log(title = "企业部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sysDeptService.deleteSysDeptByIds(ids));
	}
	
}
