package com.huayi.company.condition.system;

import com.huayi.company.condition.PageCondition;

import java.io.Serializable;

public class SysUserRoleCondition extends PageCondition implements Serializable {

    private Long companyId;

    private Long userId;

    private Long roleId;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
