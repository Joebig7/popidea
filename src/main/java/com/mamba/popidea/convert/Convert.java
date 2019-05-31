package com.mamba.popidea.convert;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/31 17:03
 */
public abstract class Convert<T, V> {

    protected abstract V convert(T t);
}