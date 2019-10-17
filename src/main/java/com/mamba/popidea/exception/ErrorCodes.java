package com.mamba.popidea.exception;


/**
 * Description 定义具体运行时异常错误编码
 * 异常码规则:
 * 1xxxx:通用错误码定义
 * 3xxxx:业务相关错误码定义
 * 4xxxx:Http相关错误码定义
 * 5xxxx:未知错误码
 * 9xxxx:统一错误码及第三方服务错误码定义
 */
public enum ErrorCodes {

    SERVICE_ERROR(500, "服务端内部错误"),
    JSON_PARSE_ERROR(10001, "JSON转换失败"),
    WEB_PARAM_PARSE_ERROR(10002, "参数转换错误"),
    PARAM_NULL_ERROR(10003, "参数不能为空"),
    PARAM_CHECK_ERROR(10004, "参数校验失败"),
    USER_LOGIN_FAULT(30001, "用户登录失败"),
    USER_NULL_ERROR(30002, "用户尚未注册，请先进行注册"),
    REGISTER_FAILURE_ERROR(30003, "用户注册失败,请查看邮箱是否正确"),
    TOKEN_CHECKED_ERROR(30004, "登录令牌已经失效"),
    USER_EXIST_ERROR(30005, "用户已存在"),
    USER_PASSWORD_ERROR(30006, "用户或密码不正确，请重新登录"),
    QUESTION_EXIST_ERROR(30007, "问题不存在"),
    KEYWORD_EXIST_ERROR(30008, "请输入关键字"),
    COLUMN_EXIST_ERROR(30009, "专栏不存在"),
    TAG_EXIST_ERROR(30010, "标签已经存在"),
    ARTICLE_EXIST_ERROR(30011, "文章不存在");

    private Integer errorCode;
    private String errorMessage;


    ErrorCodes(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }


    /**
     * 根据错误码返回错误对象
     *
     * @param errorCode 错误码
     * @return
     */
    public static ErrorCodes getErrorInfo(Integer errorCode) {
        for (ErrorCodes errorCodes : ErrorCodes.values()) {
            if (errorCode == errorCodes.getErrorCode()) {
                return errorCodes;
            }
        }
        return null;
    }

}
