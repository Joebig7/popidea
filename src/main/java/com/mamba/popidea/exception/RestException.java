package com.mamba.popidea.exception;

/**
 * Description: 响应异常类
 * author: 张家峰
 * create: 2018-08-23 03:06
 **/
public class RestException extends BaseException {

    public RestException(ErrorCodes errorCodes) {
        super(errorCodes);
    }

    public static RestException newInstance() {
        return newInstance(ErrorCodes.SERVICE_ERROR);
    }

    public static RestException newInstance(ErrorCodes errorCodes) {
        return new RestException(errorCodes);
    }

}