package com.huayi.web.controller.system;

import com.huayi.common.annotation.Log;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.page.TableDataInfo;
import com.huayi.framework.beans.SelectOption;
import com.huayi.framework.util.ShiroUtils;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.condition.system.SysRoleCondition;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysUser;
import com.huayi.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色信息
 * 
 * @author huayi
 */
@Controller
@RequestMapping("/biz/role")
public class SysRoleController extends BaseController
{
    private String prefix = "biz/role";

    @Autowired
    private ISysRoleService roleService;

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request,@RequestBody  SysRoleCondition condition)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        condition.setCompanyId(currentUser.getCompanyId());
        List<SysRole> list = roleService.selectRoleAll(condition);
        return getDataTable(list);
    }

    @PostMapping("/opt")
    @ResponseBody
    public AjaxResult options(HttpServletRequest request,@RequestBody  SysRoleCondition condition)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        condition.setCompanyId(currentUser.getCompanyId());
        List<SysRole> list = roleService.selectRoleAll(condition);
        List<SelectOption> optionList = new ArrayList<SelectOption>();
        for(SysRole role:list) {
            SelectOption optionItem= new SelectOption();
            optionItem.setLabel(role.getRoleName());
            optionItem.setValue(""+role.getRoleId().longValue());
            optionList.add(optionItem);
        }
        return success(optionList);
    }



}