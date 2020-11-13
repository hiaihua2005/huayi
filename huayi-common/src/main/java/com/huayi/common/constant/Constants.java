package com.huayi.common.constant;

/**
 * 通用常量信息
 * 
 * @author huayi
 */
public class Constants
{
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 自动去除表前缀
     */
    public static String AUTO_REOMVE_PRE = "true";

    /**
     * 当前记录起始索引
     */
    public static String PAGE_NUM = "pageNum";

    /**
     * 每页显示记录数
     */
    public static String PAGE_SIZE = "pageSize";

    /**
     * 排序列
     */
    public static String ORDER_BY_COLUMN = "orderByColumn";

    /**
     * 排序的方向 "desc" 或者 "asc".
     */
    public static String IS_ASC = "isAsc";


    /**
     * 删除标志 1 未删除 0
     */
    public static final Integer DEL_FLAG_1 = 1;

    public static final Integer DEL_FLAG_0 = 0;

    public static final Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public static final Integer SC_OK_200 = 200;

    /**
     * 访问权限认证未通过 510
     */
    public static final Integer SC_JEECG_NO_AUTHZ = 510;

    /**
     * 登录用户令牌缓存KEY前缀
     */
    public static final int TOKEN_EXPIRE_TIME = 3600; //3600秒即是一小时

    public static final String PREFIX_USER_TOKEN = "PREFIX_USER_TOKEN_";

    /**
     * 0：一级菜单
     */
    public static final Integer MENU_TYPE_0 = 0;

    /**
     * 1：子菜单
     */
    public static final Integer MENU_TYPE_1 = 1;

    /**
     * 2：按钮权限
     */
    public static final Integer MENU_TYPE_2 = 2;

    /**
     * 是否用户已被冻结 1(解冻)正常 2冻结
     */
    public static final Integer USER_UNFREEZE = 1;

    public static final Integer USER_FREEZE = 2;

    /**
     * token的key
     */
    public static String ACCESS_TOKEN = "Access-Token";

    /**
     * 登录用户规则缓存
     */
    public static final String LOGIN_USER_RULES_CACHE = "loginUser_cacheRules";

    /**
     * 登录用户拥有角色缓存KEY前缀
     */
    public static String LOGIN_USER_CACHERULES_ROLE = "loginUser_cacheRules::Roles_";

    /**
     * 登录用户拥有权限缓存KEY前缀
     */
    public static String LOGIN_USER_CACHERULES_PERMISSION = "loginUser_cacheRules::Permissions_";
}
