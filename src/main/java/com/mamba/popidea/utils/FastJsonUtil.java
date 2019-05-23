package com.mamba.popidea.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/22 15:06
 */
public class FastJsonUtil {
    static {
        JSON.DEFAULT_PARSER_FEATURE &= ~Feature.UseBigDecimal.getMask();
    }

    public static String toJSONString(Object object) {
        return JSON.toJSONString(object);
    }

    public static JSONObject parse(String text) {
        return JSON.parseObject(text);
    }

}