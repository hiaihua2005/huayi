package com.huayi.web.controller.system;

import com.huayi.common.annotation.Log;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.constant.UserConstants;
import com.huayi.common.enums.BusinessType;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.utils.StringUtils;
import com.huayi.framework.beans.SelectOption;
import com.huayi.framework.util.ShiroUtils;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.condition.system.SysRoleCondition;
import com.huayi.system.condition.system.SysRoleMenuCondition;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysRoleMenu;
import com.huayi.system.domain.SysUser;
import com.huayi.system.service.ISysMenuService;
import com.huayi.system.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @PostMapping("/info/{roleId}")
    @ResponseBody
    public AjaxResult info(HttpServletRequest request,@PathVariable("roleId") Long roleId)
    {
        SysUser currentUser = getSysUser();
        SysRoleCondition condition = new SysRoleCondition();
        condition.setCompanyId(currentUser.getCompanyId());
        condition.setRoleId(roleId);
        SysRole role = roleService.selectRoleById(condition);
        return success(role);
    }


    /**
     * 修改保存角色
     */
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request,@RequestBody  SysRole role)
    {
        SysUser currentUser = getSysUser();
        role.setCompanyId(currentUser.getCompanyId());
        role.setUpdateBy(currentUser.getUserName());
        //更新角色信息
        if(StringUtils.isEmpty(role.getRoleSort())) {
            role.setRoleSort("0");
        }
        //更新角色信息
        if(StringUtils.isEmpty(role.getStatus())) {
            role.setStatus("0");
        }
        int updateResult = roleService.updateRole(role);
        return toAjax(updateResult);
    }

    /**
     * 新增保存角色
     */
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request,@RequestBody  SysRole role)
    {
        SysUser currentUser = getSysUser();
        role.setCompanyId(currentUser.getCompanyId());
        role.setCreateBy(currentUser.getUserName());
        SysRoleCondition condition = new SysRoleCondition();
        condition.setCompanyId(currentUser.getCompanyId());
        condition.setRoleKey(role.getRoleKey());
        condition.setRoleName(role.getRoleName());
        String checkResult = roleService.checkRoleNameUnique(condition);
        if(UserConstants.ROLE_NAME_NOT_UNIQUE == checkResult) {
            return error("角色名称已存在");
        }
        checkResult = roleService.checkRoleKeyUnique(condition);
        if(UserConstants.ROLE_KEY_NOT_UNIQUE == checkResult) {
            return error("角色Key已存在");
        }
        if(StringUtils.isEmpty(role.getRoleSort())) {
            role.setRoleSort("0");
        }
        if(StringUtils.isEmpty(role.getStatus())) {
            role.setStatus("0");
        }
        return toAjax(roleService.insertRole(role));
    }


    /**
     * 修改保存用户
     */
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/updateRoleMenu")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult updateRoleMenu(HttpServletRequest request,@RequestBody SysRoleMenuCondition condition)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);

        if(currentUser==null) {
            return error("用户不存在");
        }
        if(condition.getRoleId()==null || condition.getRoleId().longValue()<=0) {
            return error("角色不存在");
        }
        if(condition.getMenuIds()==null) {
            return error("");
        }
        condition.setCompanyId(currentUser.getCompanyId());
        condition.setCurrentUserName(currentUser.getUserName());
        int updateResult = roleService.updateMenuByRoleId(condition);
        return toAjax(updateResult);
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