package com.bpf.enums;

public enum ResultCodeEnum {
    OK(200, "访问成功"),
    ERROR(300, "访问失败"),
    SUCCESS(400, "操作成功"),
    FAILED(500, "操作失败");

    private Integer code;
    private String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
