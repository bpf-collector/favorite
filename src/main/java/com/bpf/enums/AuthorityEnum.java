package com.bpf.enums;

/**
 * 用户权限
 */
public enum AuthorityEnum {
    COMMON((byte) 1, "普通用户"),
    ADMINISTRATOR((byte) 2, "管理员");

    private Byte auth;
    private String msg;

    AuthorityEnum(Byte auth, String msg) {
        this.auth = auth;
        this.msg = msg;
    }

    public Byte getAuth() {
        return auth;
    }

    public void setAuth(Byte auth) {
        this.auth = auth;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
