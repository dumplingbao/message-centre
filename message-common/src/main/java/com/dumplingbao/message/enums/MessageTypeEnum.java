package com.dumplingbao.message.enums;

public enum MessageTypeEnum {

    SYSTEM("SYSTEM", "系统消息"),
    APP("APP", "APP消息"),
    NOTICE("NOTICE", "通知消息"),
    EMAIL("EMAIL", "邮件消息"),
    SHORT("SHORT", "短信消息");

    private String code;
    private String message;

    MessageTypeEnum(String code, String message) {
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
