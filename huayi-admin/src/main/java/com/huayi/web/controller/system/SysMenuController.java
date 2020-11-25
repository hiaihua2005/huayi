package com.huayi.web.controller.system;

import java.time.LocalDateTime;
import java.util.List;

import com.huayi.framework.util.ShiroUtils;
import com.huayi.system.condition.system.SysMenuCondition;
import com.huayi.system.condition.system.SysRoleMenuCondition;
import com.huayi.system.domain.SysRole;
import com.huayi.system.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.huayi.common.annotation.Log;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.base.Ztree;
import com.huayi.common.enums.BusinessType;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.domain.SysMenu;
import com.huayi.system.service.ISysMenuService;

import javax.servlet.http.HttpServletRequest;

/**
 * 菜单信息
 * 
 * @author huayi
 */
@Controller
@RequestMapping("/biz/menu")
public class SysMenuController extends BaseController
{
    private String prefix = "biz/menu";

    @Autowired
    private ISysMenuService menuService;


    @PostMapping("/list")
    @ResponseBody
    public List<SysMenu> list(HttpServletRequest request,@RequestBody SysRole role)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        List<SysMenu> menus = null;
        menus = menuService.selectMenuAll();
        return menus;
    }

    @PostMapping("/userMenu")
    @ResponseBody
    public List<SysMenu> userMenu(HttpServletRequest request)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        SysMenuCondition condition = new SysMenuCondition();
        condition.setCompanyId(currentUser.getCompanyId());
        condition.setUserId(currentUser.getUserId());
        List<SysMenu> roleMenus = menuService.selectMenusByUser(condition);
        return roleMenus;
    }


    @PostMapping("/roleMenus")
    @ResponseBody
    public List<Long> roleMenus(HttpServletRequest request,@RequestBody SysRoleMenuCondition condition)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        condition.setCompanyId(currentUser.getCompanyId());
        List<Long> roleMenus = menuService.selectMenuIdByRole(condition);
        return roleMenus;
    }

    @PostMapping("/info/{menuId}")
    @ResponseBody
    public AjaxResult info(HttpServletRequest request,@PathVariable("menuId") Long menuId)
    {
        SysUser currentUser = getSysUser();
        SysMenu menu = menuService.selectMenuById(menuId);
        return success(menu);
    }

    /**
     * 删除菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{menuId}")
    @ResponseBody
    public AjaxResult remove(HttpServletRequest request,@PathVariable("menuId") Long menuId)
    {
        if (menuService.selectCountMenuByParentId(menuId) > 0)
        {
            return error(1, "存在子菜单,不允许删除");
        }
        if (menuService.selectCountRoleMenuByMenuId(menuId) > 0)
        {
            return error(1, "菜单已分配,不允许删除");
        }
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.deleteMenuById(menuId));
    }

    /**
     * 新增
     */
    @GetMapping("/add/{parentId}")
    public String add(@PathVariable("parentId") Long parentId, ModelMap mmap)
    {
        SysMenu menu = null;
        if (0L != parentId)
        {
            menu = menuService.selectMenuById(parentId);
        }
        else
        {
            menu = new SysMenu();
            menu.setMenuId(0L);
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return prefix + "/add";
    }

    /**
     * 新增保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request,@RequestBody SysMenu menu)
    {
        menu.setCreateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        return toAjax(menuService.insertMenu(menu));
    }


    /**
     * 修改保存菜单
     */
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HttpServletRequest request,@RequestBody SysMenu menu)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        menu.setUpdateBy(ShiroUtils.getLoginName());
        ShiroUtils.clearCachedAuthorizationInfo();
        menu.setUpdateTime(LocalDateTime.now());
        return toAjax(menuService.updateMenu(menu));
    }

    /**
     * 选择菜单图标
     */
    @GetMapping("/icon")
    public String icon()
    {
        return prefix + "/icon";
    }

    /**
     * 校验菜单名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(SysMenu menu)
    {
        return menuService.checkMenuNameUnique(menu);
    }

    /**
     * 加载角色菜单列表树
     */
    @GetMapping("/roleMenuTreeData")
    @ResponseBody
    public List<Ztree> roleMenuTreeData(SysRole role)
    {
        List<Ztree> ztrees = menuService.roleMenuTreeData(role);
        return ztrees;
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Ztree> menuTreeData(SysRole role)
    {
        List<Ztree> ztrees = menuService.menuTreeData();
        return ztrees;
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap)
    {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return prefix + "/tree";
    }
}