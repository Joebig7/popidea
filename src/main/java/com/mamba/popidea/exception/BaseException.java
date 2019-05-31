package com.mamba.popidea.exception;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 16:40
 */
public class BaseException extends RuntimeException {

    private ErrorCodes code;
    private String msg;

    protected BaseException(ErrorCodes errorCodes) {
        this(errorCodes, errorCodes.toString());
    }

    protected BaseException(ErrorCodes errorCodes, String msg) {
        super(msg);
        this.code = errorCodes;
        this.msg = msg;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public void setCode(ErrorCodes code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}