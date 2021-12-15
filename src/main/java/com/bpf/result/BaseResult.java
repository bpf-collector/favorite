package com.bpf.result;

import com.bpf.enums.ResultCodeEnum;
import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseResult {
    // 访问代码: 200-成功, 300-失败
    private Integer accessCode;

    // 操作代码: 400-成功, 500-失败
    private Integer processCode;

    private String message;
    // 分页信息
    private PageInfo<?> pageInfo;
    // 拓展信息
    private Map<String, Object> ext;

    // 访问成功:操作成功
    public static BaseResult ok() {
        return new BaseResult(ResultCodeEnum.OK.getCode(), ResultCodeEnum.SUCCESS.getCode(),
                ResultCodeEnum.OK.getDesc() + ":" + ResultCodeEnum.SUCCESS.getDesc());
    }

    // 访问成功:操作失败
    public static BaseResult failed() {
        return new BaseResult(ResultCodeEnum.OK.getCode(), ResultCodeEnum.FAILED.getCode(),
                ResultCodeEnum.OK.getDesc() + ":" + ResultCodeEnum.FAILED.getDesc());
    }

    // 访问失败:操作失败
    public static BaseResult error() {
        return new BaseResult(ResultCodeEnum.ERROR.getCode(), ResultCodeEnum.FAILED.getCode(),
                ResultCodeEnum.ERROR.getDesc() + ":" + ResultCodeEnum.FAILED.getDesc());
    }

    public BaseResult addMsg(String key, String msg) {
        if (CollectionUtils.isEmpty(ext)) {
            ext = new HashMap<>();
            this.setExt(ext);
        }

        ext.put(key, msg);
        return this;
    }

    public BaseResult(Integer accessCode, Integer processCode, String message) {
        this.accessCode = accessCode;
        this.processCode = processCode;
        this.message = message;
    }

    public Integer getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(Integer accessCode) {
        this.accessCode = accessCode;
    }

    public Integer getProcessCode() {
        return processCode;
    }

    public void setProcessCode(Integer processCode) {
        this.processCode = processCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PageInfo<?> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<?> pageInfo) {
        this.pageInfo = pageInfo;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }
}
