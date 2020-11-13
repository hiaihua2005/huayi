package com.huayi.common.exception.user;

import com.huayi.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author huayi
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
