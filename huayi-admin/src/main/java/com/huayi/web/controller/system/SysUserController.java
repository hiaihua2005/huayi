package com.huayi.web.controller.system;

import java.time.LocalDateTime;
import java.util.List;

import com.huayi.framework.util.ShiroUtils;
import com.huayi.service.ICardService;
import com.huayi.service.ITestMe;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.huayi.common.annotation.Log;
import com.huayi.common.base.AjaxResult;
import com.huayi.common.enums.BusinessType;
import com.huayi.common.page.TableDataInfo;
import com.huayi.common.utils.StringUtils;
import com.huayi.common.utils.poi.ExcelUtil;
import com.huayi.framework.shiro.service.SysPasswordService;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.domain.SysUser;
import com.huayi.system.service.ISysRoleService;
import com.huayi.system.service.ISysUserService;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户信息
 * 
 * @author huayi
 */
@Controller
@RequestMapping("/biz/user")
@Slf4j
public class SysUserController extends BaseController
{
    private String prefix = "biz/user";

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;


    @Autowired
    private SysPasswordService passwordService;

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request,SysUser user)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        user.setCompanyId(currentUser.getCompanyId());
        startPage();
        List<SysUser> list = userService.selectUserList(user);
        return getDataTable(list);
    }


    @PostMapping("/info/{userId}")
    @ResponseBody
    public AjaxResult info(HttpServletRequest request,@PathVariable("userId") Long userId)
    {
        SysUser currentUser = getSysUser();
        SysUser user = userService.selectUserById(currentUser.getCompanyId(),userId);
        return success(user);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysUser user)
    {
        SysUser currentUser = getSysUser();
        List<SysUser> list = userService.selectUserList(user);
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(list, "用户数据");
    }

    @Log(title = "用户管理", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        SysUser currentUser = getSysUser();
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = getSysUser().getLoginName();
        String message = userService.importUser(currentUser.getCompanyId(),userList, updateSupport, operName);
        return AjaxResult.success(message);
    }

    /**
     * 新增保存用户
     */
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult addSave(HttpServletRequest request,SysUser user)
    {
        SysUser currentUser = ShiroUtils.getSysUser(request);
        if (StringUtils.isNotNull(user.getUserId()) && user.getLoginName().equals("admin"))
        {
            return error("不允许修改超级管理员用户");
        }
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getPassword(), user.getSalt()));
        user.setCreateUserId(currentUser.getUserId());
        user.setCreateUserName(currentUser.getUserName());
        user.setCreateTime(LocalDateTime.now());
        return toAjax(userService.insertUser(user));
    }


    /**
     * 修改保存用户
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @Transactional(rollbackFor = Exception.class)
    @ResponseBody
    public AjaxResult editSave(@RequestBody  SysUser editUser)
    {
        SysUser currentUser = getSysUser();
        if (StringUtils.isNotNull(editUser.getUserId()) && editUser.getLoginName().equals("admin"))
        {
            return error("不允许修改超级管理员用户");
        }
        editUser.setCompanyId(currentUser.getCompanyId());
        SysUser currentOpereationUser = ShiroUtils.getSysUser();
        editUser.setUpdateUserId(currentOpereationUser.getUpdateUserId());
        editUser.setUpdateUserName(currentOpereationUser.getUserName());
        editUser.setUpdateTime(LocalDateTime.now());
        //更新用户信息
        int updateResult = userService.updateUser(editUser);
        return toAjax(updateResult);
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        SysUser currentUser = getSysUser();
        mmap.put("user", userService.selectUserById(currentUser.getCompanyId(),userId));
        return prefix + "/resetPwd";
    }

    @Log(title = "重置密码", businessType = BusinessType.UPDATE)
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(SysUser user)
    {
        SysUser currentUser = getSysUser();
        user.setCompanyId(currentUser.getCompanyId());
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(passwordService.encryptPassword(user.getPassword(), user.getSalt()));
        return toAjax(userService.resetUserPwd(user));
    }

    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        SysUser currentUser = getSysUser();
        try  {
            return toAjax(userService.deleteUserByIds(currentUser.getCompanyId(),ids));
        }
        catch (Exception e)  {
            return error(e.getMessage());
        }
    }

    /**
     * 校验用户名
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(SysUser user)
    {
        return userService.checkLoginNameUnique(user.getLoginName());
    }

    /**
     * 校验手机号码
     */
    @PostMapping("/checkPhoneUnique")
    @ResponseBody
    public String checkPhoneUnique(SysUser user)
    {
        return userService.checkPhoneUnique(user);
    }

    /**
     * 校验email邮箱
     */
    @PostMapping("/checkEmailUnique")
    @ResponseBody
    public String checkEmailUnique(SysUser user)
    {
        return userService.checkEmailUnique(user);
    }

    /**
     * 用户状态修改
     */
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysUser user)
    {
        return toAjax(userService.changeStatus(user));
    }
}