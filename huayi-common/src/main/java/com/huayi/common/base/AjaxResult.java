package com.huayi.common.base;

import java.io.Serializable;

/**
 * 操作消息提醒
 * 
 * @author huayi
 */
public class AjaxResult<T> implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Integer code;


    public String message;

    public T data;


    /**
     * 初始化一个新创建的 Message 对象
     */
    public AjaxResult()
    {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回错误消息
     * 
     * @return 错误消息
     */
    public static AjaxResult error(Object data)
    {
        return error(1, "操作失败",null);
    }

    /**
     * 返回错误消息
     * 
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(String msg,Object data)
    {
        return error(500, msg,null);
    }

    /**
     * 返回错误消息
     * 
     * @param code 错误码
     * @param msg 内容
     * @return 错误消息
     */
    public static AjaxResult error(int code, String msg,Object data)
    {
        AjaxResult json = new AjaxResult();
        json.setCode(code);
        json.setMessage(msg);
        json.setData(data);
        return json;
    }

    /**
     * 返回成功消息
     * 
     * @param msg 内容
     * @return 成功消息
     */
    public static AjaxResult success(String msg,Object data)
    {
        AjaxResult json = new AjaxResult();
        json.setCode(0);
        json.setMessage(msg);
        json.setData(data);
        return json;
    }
    
    /**
     * 返回成功消息
     * 
     * @return 成功消息
     */
    public static AjaxResult success(Object data)
    {
        return AjaxResult.success("操作成功",data);
    }


}
