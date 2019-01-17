package com.bby.hotel.exception;

public enum EmErrorMsg implements CommonException {
    //通用错误类型 1000x
    UNKNOWER_ERROR(10001,"未知错误"),
    PARAMETER_VALIDATION_ERROR(10002,"参数不合法"),
    //用户 2000x
    USER_NOT_EXIT_ERROR(20001, "用户不存在"),
    USER_PASSWORD_NOT_MATCH_ERROR(20002, "密码不正确")

    ;

    private EmErrorMsg(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonException setErrorMsg(String errorMsg) {
        this.errMsg = errorMsg;
        return this;
    }
}
