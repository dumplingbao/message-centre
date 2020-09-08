package com.dumplingbao.message.enums;


/**
 * 返回结果类型
 * Created by TJ on 2018/6/19.
 */
public enum ResponseCodeEnum {

    SUCCESS("0", "成功"),
    FAILED("1", "失败"),
    PARAM_ERROR("2", "参数错误"),
    SEND_LIMIT("3", "请求太频繁，请稍后再试"),
    OTHER_ERROR("999", "系统错误");

    private String code;
    private String message;

    ResponseCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
