package com.fh.exception;

import com.fh.common.ResponseEnum;

public class AuthenticateException extends RuntimeException{
    private Integer code;
    public AuthenticateException(ResponseEnum serverEnum) {
        super(serverEnum.getMsg());
        this.code=serverEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }

}
