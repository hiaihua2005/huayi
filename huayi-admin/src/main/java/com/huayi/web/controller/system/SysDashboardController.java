package com.huayi.web.controller.system;

import com.huayi.common.base.AjaxResult;
import com.huayi.common.constant.Constants;
import com.huayi.common.json.JSONObject;
import com.huayi.common.utils.StringUtils;
import com.huayi.framework.cache.ShardedRedisUtil;
import com.huayi.framework.jwt.JwtUtil;
import com.huayi.framework.web.base.BaseController;
import com.huayi.system.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 登录验证
 *
 * @author huayi
 */
@Controller
public class SysDashboardController extends BaseController {

    @PostMapping("/biz/dash/total")
    @ResponseBody
    public AjaxResult ajaxDashBoardTotal() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clue",100);jsonObject.put("newClue",100);
        jsonObject.put("customerFlow",100); jsonObject.put("newCustomerFlow",100);
        jsonObject.put("customer",100);jsonObject.put("newCustomer",100);
        jsonObject.put("totalAmount",100);jsonObject.put("newAmount",100);

        return success(jsonObject);
    }

    @PostMapping("/biz/dash/sale")
    @ResponseBody
    public AjaxResult ajaxDashBoardSale() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("clue",100);jsonObject.put("newClue",100);
        jsonObject.put("customerFlow",100); jsonObject.put("newCustomerFlow",100);
        jsonObject.put("customer",100);jsonObject.put("newCustomer",100);
        jsonObject.put("totalAmount",100);jsonObject.put("newAmount",100);

        return success(jsonObject);
    }
}
