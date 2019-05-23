package com.mamba.popidea.utils;

import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.RestException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 13:58
 */
public class CommonUtil {

    public static Long getUserId() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        try {
            return Long.valueOf(request.getAttribute("userId").toString());
        } catch (NumberFormatException e) {
            throw RestException.newInstance(ErrorCodes.TOKEN_CHECKED_ERROR);
        }
    }
}