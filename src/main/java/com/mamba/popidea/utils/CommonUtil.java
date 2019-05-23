package com.mamba.popidea.utils;

import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.RestException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 13:58
 * @description 封装 popidea专用工具
 */
public class CommonUtil {

    public static Long getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            return Long.valueOf(request.getAttribute("userId").toString());
        } catch (NumberFormatException e) {
            throw RestException.newInstance(ErrorCodes.TOKEN_CHECKED_ERROR);
        }
    }
}