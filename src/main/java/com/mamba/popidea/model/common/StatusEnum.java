package com.mamba.popidea.model.common;

public enum StatusEnum {


    OK("ok"),
    FALSE("failure");

    private String status;

    StatusEnum(String status) {
        this.status = status;
    }


}
