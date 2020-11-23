package com.huayi.system.condition.system;

import com.huayi.system.condition.PageCondition;

import java.io.Serializable;

public class SysRoleCondition extends PageCondition implements Serializable {

    private Long companyId;

    private Long userId;

    private Long roleId;

    private String roleKey;

    private String roleName;

    private String status;

    private String dataScope;

    private String delFlag;

    private SysRoleParamsCondition params;

    public SysRoleCondition() {
        this.params = new SysRoleParamsCondition();
    }


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

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope) {
        this.dataScope = dataScope;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public SysRoleParamsCondition getParams() {
        return params;
    }

    public void setParams(SysRoleParamsCondition params) {
        this.params = params;
    }
}
