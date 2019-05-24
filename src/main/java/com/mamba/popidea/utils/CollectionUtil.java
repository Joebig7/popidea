package com.mamba.popidea.utils;

import java.util.List;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/24 14:55
 */
public class CollectionUtil {

    public static boolean NotEmpty(List list) {
        return list != null && list.size() > 0;
    }
}