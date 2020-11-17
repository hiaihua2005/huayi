package com.huayi.company.condition.system;

import com.huayi.company.condition.PageCondition;

import java.io.Serializable;

/**
 * 用户删除条件
 */
public class SysUserBatchDeleteCondition extends PageCondition implements Serializable {

    private Long companyId;

    private String[] userId;


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String[] getUserId() {
        return userId;
    }

    public void setUserId(String[] userId) {
        this.userId = userId;
    }
}
