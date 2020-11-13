package com.huayi.web.controller.scrm;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.huayi.common.annotation.Log;
import com.huayi.common.enums.BusinessType;
import com.huayi.scrm.domain.Contact;
import com.huayi.scrm.service.IContactService;
import com.huayi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.utils.poi.ExcelUtil;

/**
 * 人脉关系记录 信息操作处理
 * 
 * @author huayi
 * @date 2020-08-16
 */
@Controller
@RequestMapping("/biz/scrm/contact")
public class ContactController extends BaseController
{
    private String prefix = "biz/scrm/contact";
	
	@Autowired
	private IContactService contactService;

	/**
	 * 查询人脉关系记录列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Contact contact)
	{
		startPage();
        List<Contact> list = contactService.selectContactList(contact);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人脉关系记录列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Contact contact)
    {
    	List<Contact> list = contactService.selectContactList(contact);
        ExcelUtil<Contact> util = new ExcelUtil<Contact>(Contact.class);
        return util.exportExcel(list, "contact");
    }
	

	/**
	 * 新增保存人脉关系记录
	 */
	@Log(title = "人脉关系记录", businessType = BusinessType.INSERT)
	@PostMapping("/save")
	@ResponseBody
	public AjaxResult save(Contact contact)
	{		
		return toAjax(contactService.insertContact(contact));
	}

	/**
	 * 获取人脉关系记录
	 */
	@PostMapping("/info/{recordId}")
	@ResponseBody
	public AjaxResult info(@PathVariable("recordId") Integer recordId, ModelMap mmap)
	{
		Contact contact = contactService.selectContactById(recordId);
	    return toAjax(true,contact);
	}
	
	/**
	 * 修改保存人脉关系记录
	 */
	@Log(title = "人脉关系记录", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult edit(Contact contact)
	{		
		return toAjax(contactService.updateContact(contact));
	}
	
	/**
	 * 删除人脉关系记录
	 */
	@Log(title = "人脉关系记录", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(contactService.deleteContactByIds(ids));
	}
	
}
