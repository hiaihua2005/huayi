package com.huayi.system.condition.system;

import com.huayi.system.condition.PageCondition;

public class SysRoleMenuCondition extends PageCondition {

    private Long companyId;

    private Long roleId;

    private Long[] menuIds;


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

    public Long[] getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(Long[] menuIds) {
        this.menuIds = menuIds;
    }
}
