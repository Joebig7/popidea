package com.mamba.popidea.handler;

import com.google.common.collect.Maps;
import com.mamba.popidea.exception.JsonException;
import com.mamba.popidea.exception.RestException;
import com.mamba.popidea.exception.ServiceException;
import com.mamba.popidea.model.common.result.RestResp;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.mamba.popidea.exception.ErrorCodes.PARAM_CHECK_ERROR;
import static com.mamba.popidea.exception.ErrorCodes.WEB_PARAM_PARSE_ERROR;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 17:01
 * @description 全局异常处理器
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResp exceptionHandler(Exception exception) {
        if (exception instanceof JsonException) {
            JsonException jsonException = JsonException.newInstance();
            return getErrorMap(jsonException.getMsg(), jsonException.getCode().getErrorCode());
        } else if (exception instanceof RestException) {
            return getErrorMap(((RestException) exception).getCode().getErrorMessage(), ((RestException) exception).getCode().getErrorCode());
        } else if (exception instanceof ServiceException) {
            return getErrorMap(((ServiceException) exception).getCode().getErrorMessage(), ((ServiceException) exception).getCode().getErrorCode());
        } else if (exception instanceof HttpMessageNotReadableException) {
            return getErrorMap(WEB_PARAM_PARSE_ERROR.getErrorMessage(), WEB_PARAM_PARSE_ERROR.getErrorCode());
        } else if (exception instanceof BindException) {
            StringBuilder errorMsg = new StringBuilder();
            ((BindException) exception).getAllErrors().forEach(msg -> errorMsg.append(msg));
            return getErrorMap(errorMsg.toString(), PARAM_CHECK_ERROR.getErrorCode());
        }

        return null;
    }

    public static RestResp getErrorMap(String msg, Integer errorCode) {
        Map<String, Object> errorMap = Maps.newHashMap();
        errorMap.put("msg", msg);
        errorMap.put("errorCode", errorCode);
        return new RestResp<>(errorMap);

    }

}