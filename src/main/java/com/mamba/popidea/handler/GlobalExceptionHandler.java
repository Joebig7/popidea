package com.mamba.popidea.handler;

import com.google.common.collect.Maps;
import com.mamba.popidea.exception.JsonException;
import com.mamba.popidea.exception.RestException;
import com.mamba.popidea.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import static com.mamba.popidea.exception.ErrorCodes.*;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 17:01
 * @description 全局异常处理器
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(Exception exception) {
        if (exception instanceof JsonException) {
            log.error("【全局异常拦截】JsonException",exception.getMessage());
            JsonException jsonException = JsonException.newInstance();
            return getErrorMap(jsonException.getMsg(), jsonException.getCode().getErrorCode());
        } else if (exception instanceof RestException) {
            log.info(((RestException) exception).getMsg());
            return getErrorMap(((RestException) exception).getCode().getErrorMessage(), ((RestException) exception).getCode().getErrorCode());
        } else if (exception instanceof ServiceException) {
            log.info(((ServiceException) exception).getMsg());
            return getErrorMap(((ServiceException) exception).getCode().getErrorMessage(), ((ServiceException) exception).getCode().getErrorCode());
        } else if (exception instanceof HttpMessageNotReadableException) {
            log.info(exception.getMessage());
            return getErrorMap(WEB_PARAM_PARSE_ERROR.getErrorMessage(), WEB_PARAM_PARSE_ERROR.getErrorCode());
        } else if (exception instanceof BindException) {
            log.info(exception.getMessage());
            StringBuilder errorMsg = new StringBuilder();
            ((BindException) exception).getAllErrors().forEach(msg -> errorMsg.append(msg));
            return getErrorMap(errorMsg.toString(), PARAM_CHECK_ERROR.getErrorCode());
        } else {
            log.info(exception.getMessage());
            return getErrorMap(SERVICE_ERROR.getErrorMessage(), SERVICE_ERROR.getErrorCode());
        }
    }

    public static Map<String, Object> getErrorMap(String msg, Integer errorCode) {
        Map<String, Object> errorMap = Maps.newHashMap();
        errorMap.put("msg", msg);
        errorMap.put("errorCode", errorCode);
        return errorMap;
    }

}