package com.bby.hotel.exception;


public interface CommonException {

    public int getErrorCode();

    public String getErrorMsg();

    public CommonException setErrorMsg(String errorMsg);


}
