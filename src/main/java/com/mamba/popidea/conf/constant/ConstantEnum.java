package com.mamba.popidea.conf.constant;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/21 14:55
 */
public enum ConstantEnum {

    USERID("userId");


    ConstantEnum(String field) {
        this.field = field;

    }


    private String field;

    public String field() {
        return field;
    }
}