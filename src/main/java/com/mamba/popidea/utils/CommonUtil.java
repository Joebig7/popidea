package com.mamba.popidea.utils;

import com.mamba.popidea.dao.UserBeanMapper;
import com.mamba.popidea.exception.ErrorCodes;
import com.mamba.popidea.exception.RestException;
import com.mamba.popidea.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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


    private static UserBeanMapper userBeanMapper;

    @Autowired
    public static void setUserBeanMapper(UserBeanMapper userBeanMapper) {
        CommonUtil.userBeanMapper = userBeanMapper;
    }

    /**
     * 获取用户id
     *
     * @return
     */
    public static Long getUserId() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        try {
            return Long.valueOf(request.getAttribute("userId").toString());
        } catch (NumberFormatException e) {
            throw RestException.newInstance(ErrorCodes.TOKEN_CHECKED_ERROR);
        }
    }


    public static <T> void assertNull(T t, ErrorCodes errorCodes) {
        if (t == null) {
            ServiceException.newInstance(errorCodes);
        }
    }
}