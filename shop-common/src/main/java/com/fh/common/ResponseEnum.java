package com.fh.common;

public enum ResponseEnum {
    SERVER_CONNECT_ERROR (3004,"连接失败"),
    SERVER_ERROR (3003,"请求失败"),
    SERVER_BUSYNESS (3002,"服务器繁忙"),
    TOKEN_TIMEOUT (3000,"token超时，token失效了"),
    SAFETY_ERROR (3001,"token解析失败"),
    CODE_ERROR (2000,"验证码错误"),
    CODE_PHONE_NULL (2001,"手机号和验证码不能为空"),
    EXPORT_NULL (1009,"没有相关数据"),
    EMAIL_ERROR (1008,"邮箱不存在"),
    USER_PASSWORD_SUCCESS (1007,"密码修改成功，请跳转页面"),
    USER_PASSWORD_ERROR (1006,"原密码不一致"),
    USER_NEWPASSWORD_ERROR (1005,"两次密码不一致"),
    USER_PASSWORD_NULL (1004,"请输入密码"),
    ISLOCK_ERROR (1003,"账号锁定"),
    PASSWORD_ERROR (1002,"密码错误"),
    USERNAME_ERROR (1001,"账号不存在"),
    PHONE_ISNULL (1011,"请填写手机号"),
    USERNAME_PASSWORD_IS_NULL  (1000,"账号或密码不能为空");
    private Integer code;
    private String msg;

    private ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
