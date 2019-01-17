package com.bby.hotel.exception;

public class BusinessException extends Exception implements CommonException{

    private CommonException mCommonException;

    public BusinessException(CommonException commonException){
        super();
        this.mCommonException = commonException;
    }

    @Override
    public int getErrorCode() {
        return mCommonException.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return mCommonException.getErrorMsg();
    }

    @Override
    public CommonException setErrorMsg(String errorMsg) {
        this.mCommonException.setErrorMsg(errorMsg);
        return this;
    }


}
