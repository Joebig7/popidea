package com.mamba.popidea.exception;

/**
 * @version 1.0
 * @author: JoeBig7
 * @date: 2019/5/20 16:46
 * @description 业务层异常
 */
public class ServiceException extends BaseException {

    public ServiceException(ErrorCodes errorCodes) {
        super(errorCodes);
    }

    public static ServiceException newInstance() {
        return newInstance(ErrorCodes.SERVICE_ERROR);
    }

    public static ServiceException newInstance(ErrorCodes errorCodes) {
        return new ServiceException(errorCodes);
    }
}