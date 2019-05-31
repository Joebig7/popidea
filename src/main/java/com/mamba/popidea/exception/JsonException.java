package com.mamba.popidea.exception;

/**
 * @program: JsonException
 * @Description: Json转换异常类
 * @author: 张家峰 Joe
 * @create: 2018-08-21 02:28
 **/
public class JsonException extends BaseException {

    public JsonException(ErrorCodes errorCodes) {
        super(errorCodes);
    }

    public static JsonException newInstance() {
        return newInstance(ErrorCodes.JSON_PARSE_ERROR);
    }

    public static JsonException newInstance(ErrorCodes errorCodes) {
        return new JsonException(errorCodes);
    }
}