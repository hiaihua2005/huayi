package com.huayi.system.condition.system;

import com.huayi.system.condition.PageCondition;

public class SysMenuCondition extends PageCondition {

    private Long companyId;

    private Long roleId;

    private Long menuId;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
