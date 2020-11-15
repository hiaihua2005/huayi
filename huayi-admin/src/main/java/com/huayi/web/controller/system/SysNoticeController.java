package com.huayi.web.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.huayi.common.base.AjaxResult;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * 通知公告
 *
 * @author huayi
 */
@Controller
public class SysNoticeController extends BaseController {

    @PostMapping("/biz/notice/list")
    @ResponseBody
    public AjaxResult ajaxDashBoard() {
        startPage();
        List noticeList = new ArrayList();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",1);jsonObject.put("title","系统重大升级哦......");
        jsonObject.put("date","2020-10-25 10:00:05");jsonObject.put("isRead",1);
        jsonObject.put("content","系统公告：2020年1月更新了部分内容，详情点击查看");
        noticeList.add(jsonObject);
        return success(getDataTable(noticeList));
    }
}
