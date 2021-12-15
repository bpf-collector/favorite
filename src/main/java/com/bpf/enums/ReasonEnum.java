package com.bpf.enums;

public enum ReasonEnum {
    NO_LOGIN(101, "您尚未登录"),
    NO_AUTH(102, "您的权限不够"),
    NO_USER(103, "您的用户信息不存在"),
    NAME_EXISTS(104, "您的用户名已被占用"),
    NO_NAME(105, "您的用户名不能为空"),
    NO_PASSWORD(106, "您的密码不能为空"),
    ID_NOT_EXISTS(107, "此用户ID不存在");

    private Integer code;
    private String msg;

    ReasonEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
