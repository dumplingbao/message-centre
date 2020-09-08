package com.dumplingbao.message.core;

import com.dumplingbao.message.enums.ResponseCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by TJ on 2018/7/31.
 */
@Data
public class BaseResponse<T> implements Serializable {

    public BaseResponse() {
    }

    /**
     * 响应时间
     */
    private Long responseTime = System.currentTimeMillis();

    private String code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return ResponseCodeEnum.SUCCESS.getCode().equals(code);
    }

    public BaseResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResponse(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResponse success() {
        return new BaseResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage());
    }

    public static <T> BaseResponse success(T data) {
        return new BaseResponse(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMessage(), data);
    }

    public static BaseResponse error(String code, String message) {
        return new BaseResponse(code, message);
    }

    public static BaseResponse error(String message) {
        return new BaseResponse(ResponseCodeEnum.FAILED.getCode(), message);
    }

    public static BaseResponse error(ResponseCodeEnum responseCodeEnum) {
        return error(responseCodeEnum.getCode(), responseCodeEnum.getMessage());
    }

}
