package com.huayi.system.condition;

import java.io.Serializable;

/**
 * 查询基础类
 * 包括分页信息以及检索文字内容
 */
public class PageCondition implements Serializable {


    /** 每页记录行 */
    private Integer pageSize;

    /** 当前页 */
    private Integer pageNum;

    /** 检索文字 */
    private String searchText;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
