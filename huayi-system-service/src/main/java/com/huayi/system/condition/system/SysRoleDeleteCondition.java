package com.huayi.system.condition.system;

import com.huayi.system.condition.PageCondition;

import java.io.Serializable;

public class SysRoleDeleteCondition extends PageCondition implements Serializable {

    private Long companyId;

    private Long[] roleIds;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }
}
