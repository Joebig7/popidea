package com.mamba.popidea.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/10/10 14:58
 * @description
 */
@Component
public class BeanBoConverter<S, T> implements Converter<S, T> {

    private T t;

    public BeanBoConverter(T t) {
        this.t = t;

    }

    @Nullable
    @Override
    public T convert(S source) {
        BeanUtils.copyProperties(source, t);
        return t;
    }
}