package com.mamba.popidea.utils;

import java.util.Date;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 13:34
 */
public final class DateUtil {

    /**
     * 获取当前日期
     * @return
     */
    public static  Date getCurrentTime() {
        return new Date(System.currentTimeMillis());
    }

    public static Long getCurrentTimeMillis(){
        return System.currentTimeMillis();
    }
}