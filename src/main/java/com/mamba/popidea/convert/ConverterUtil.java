package com.mamba.popidea.convert;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/17 14:45
 * @description
 */
public class ConverterUtil {
    public static <T, S> T convertBeanBo(T t, S s) {
        BeanBoConverter converter = new BeanBoConverter(t);
        return (T) converter.convert(s);
    }
}